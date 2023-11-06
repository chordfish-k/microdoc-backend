package com.microdoc.pojo.vo;

import com.microdoc.pojo.dto.ReportDataDTO;
import com.microdoc.pojo.po.ReportCapture;
import com.microdoc.pojo.po.ReportData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder // 允许使用builder链式创建对象
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "查询报告返回的数据格式")
public class ReportVO {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("用户主键值")
    private Long userId;

    @ApiModelProperty("上传时间")
    private LocalDateTime uploadTime;

    @ApiModelProperty("数据列表")
    private List<ReportData> datas;

    @ApiModelProperty("捕获列表")
    private List<ReportCapture> captures;
}
