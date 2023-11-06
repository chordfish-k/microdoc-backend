package com.microdoc.service.impl;

import com.microdoc.constants.MessageConstant;
import com.microdoc.constants.StatusConstant;
import com.microdoc.exception.AccountLockedException;
import com.microdoc.exception.AccountNotFoundException;
import com.microdoc.exception.PasswordErrorException;
import com.microdoc.mapper.UserMapper;
import com.microdoc.pojo.dto.UserAddDTO;
import com.microdoc.pojo.dto.UserLoginDTO;
import com.microdoc.pojo.po.User;
import com.microdoc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String phone = userLoginDTO.getPhone();
        String pwd = userLoginDTO.getPwd();

        //1、根据用户名查询数据库中的数据
        User user = userMapper.getByPhone(phone);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        if (user.getEnable() == StatusConstant.DISABLE) {
            // 账号被禁用(锁定)
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //密码比对
        //需要进行md5加密，然后再进行比对
        pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        if (!pwd.equals(user.getPwd())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getEnable() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return user;
    }

    /**
     * 新建用户
     * @param userAddDTO
     */
    @Override
    public void insert(UserAddDTO userAddDTO) {
        String pwd = userAddDTO.getPwd();
        pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());

        User user = User.builder()
                .phone(userAddDTO.getPhone())
                .name(userAddDTO.getName())
                .pwd(pwd)
                .enable(StatusConstant.ENABLE)
                .isAdmin(StatusConstant.NORMAL)
                .build();

        userMapper.insert(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> queryAll() {
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {
            String phone = user.getPhone();
            int len = phone.length();
            user.setPhone(phone.substring(0, 3) + "*****" + phone.substring(len-3, len));
        }
        return userList;
    }

    /**
     * 用户启禁用
     * @param enable
     * @param id
     */
    @Override
    public void enableOrDisable(Integer enable, Long id) {
        User user = User.builder()
                .enable(enable!=0)
                .id(id)
                .build();
        userMapper.update(user);
    }
}
