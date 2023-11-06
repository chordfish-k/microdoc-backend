package com.microdoc.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportCapture {
    private Long id;
    private Long reportId;
    private String imgB64;
    private Integer before;
    private Integer after;
    private String time;
}
