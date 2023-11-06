package com.microdoc.mapper;

import com.microdoc.pojo.po.ReportCapture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportCaptureMapper {
    /**
     * 根据报告id查询
     * @param reportId
     * @return
     */
    @Select("select id, report_id, substring(img_b64, 4) as img_b64, `before`, `after`, `time` from report_capture where report_id=#{reportId}")
    List<ReportCapture> findByReportId(Long reportId);
}
