package com.microdoc.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder // 允许使用builder链式创建对象
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "登录返回的数据格式")
public class UserLoginVO implements Serializable {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("jwt令牌")
    private String token;

    @ApiModelProperty("是否为管理")
    private Boolean isAdmin;

}
