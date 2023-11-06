package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("单个报告图表的横纵轴数据类型")
public class ReportDataDTO {

    @ApiModelProperty("逗号(,)分隔的横轴序列")
    private String x;

    @ApiModelProperty("逗号(,)分隔的纵轴序列")
    private String y;

    @ApiModelProperty("数据类型")
    private Integer type;
}
