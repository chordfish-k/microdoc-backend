package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新建用户时传递的数据模型")
public class UserAddDTO extends UserLoginDTO {

    @ApiModelProperty("用户名")
    private String name;

}
