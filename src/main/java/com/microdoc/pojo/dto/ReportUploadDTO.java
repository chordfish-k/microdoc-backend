package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("报告上传时传递的数据类型")
public class ReportUploadDTO {

    @ApiModelProperty("表数据")
    private List<ReportDataDTO> datas;
}
