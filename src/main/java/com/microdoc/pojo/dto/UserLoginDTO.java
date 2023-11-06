package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "登录时传递的数据模型")
public class UserLoginDTO implements Serializable {

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("密码")
    private String pwd;

}