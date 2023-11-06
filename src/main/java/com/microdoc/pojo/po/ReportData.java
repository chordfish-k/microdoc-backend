package com.microdoc.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {
    private Long id;
    private Long reportId;
    private String x; // 横轴值序列，逗号,分隔
    private String y; // 纵轴值序列，逗号,分
    private Integer type;
}
