package com.microdoc.mapper;

import com.microdoc.pojo.dto.ReportDataDTO;
import com.microdoc.pojo.po.ReportData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportDataMapper {

    /**
     * 批量插入报告数据
     * @param datas
     */
    void insertBatch(List<ReportData> datas);

    /**
     * 根据报告id查询所有数据
     * @param reportId
     * @return
     */
    @Select("select * from report_data where report_id=#{reportId}")
    List<ReportData> findByReportId(Long reportId);

    /**
     * 根报告id和数据类型查询
     * @param reportData
     * @return
     */
    ReportData find(ReportData reportData);
}
