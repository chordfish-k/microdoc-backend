package com.microdoc.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("捕获数据上传时传递的数据类型")
public class ReportCaptureDTO {
    private String imgB64;
    private Integer before;
    private Integer after;
    private String time;
}
