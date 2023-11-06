package com.microdoc.pojo.vo;

import com.microdoc.pojo.dto.ReportDataDTO;
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
public class ReportDataVO {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("逗号(,)分隔的横轴序列")
    private String x;

    @ApiModelProperty("逗号(,)分隔的纵轴序列")
    private String y;

    @ApiModelProperty("数据类型")
    private Integer type;
}
