package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("单个报告图表的查询数据类型")
public class ReportDataQueryDTO {
    @ApiModelProperty("所属报告id")
    private Long reportId;
    @ApiModelProperty("数据类型")
    private Integer type;
}
