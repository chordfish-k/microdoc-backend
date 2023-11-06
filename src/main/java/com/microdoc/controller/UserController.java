package com.microdoc.controller;

import com.microdoc.constants.JwtClaimsConstant;
import com.microdoc.pojo.dto.UserAddDTO;
import com.microdoc.pojo.dto.UserLoginDTO;
import com.microdoc.pojo.po.User;
import com.microdoc.pojo.result.Result;
import com.microdoc.pojo.vo.UserLoginVO;
import com.microdoc.properties.JwtProperties;
import com.microdoc.service.UserService;
import com.microdoc.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "用户相关接口")
public class UserController {

    private final UserService userService;
    private final JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);

        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, userLoginVO);
        userLoginVO.setToken(token);

        return Result.success(userLoginVO);
    }


    /**
     * 新建用户
     * @param userAddDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新建用户")
    public Result insert(@RequestBody UserAddDTO userAddDTO) {
        log.info("新建用户：{}", userAddDTO);

        userService.insert(userAddDTO);

        return Result.success();
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    @ApiOperation("查询所有用户")
    public Result queryAll() {
        log.info("查询所有用户");

        List<User> users = userService.queryAll();

        return Result.success(users);
    }

    /**
     * 用户启禁用
     * @param enable
     * @param id
     * @return
     */
    @PutMapping("/enable/{enable}")
    @ApiOperation("用户启禁用")
    public Result enableOrDisable(@PathVariable Integer enable, Long id) {
        log.info("用户启禁用：{}，{}", enable, id);

        userService.enableOrDisable(enable, id);

        return Result.success();
    }
}
