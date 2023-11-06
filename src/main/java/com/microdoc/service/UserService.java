package com.microdoc.service;

import com.microdoc.pojo.dto.UserAddDTO;
import com.microdoc.pojo.dto.UserLoginDTO;
import com.microdoc.pojo.po.User;

import java.util.List;


public interface UserService {

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 新建用户
     * @param userAddDTO
     */
    void insert(UserAddDTO userAddDTO);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAll();

    /**
     * 用户启禁用
     * @param enable
     * @param id
     */
    void enableOrDisable(Integer enable, Long id);
}
