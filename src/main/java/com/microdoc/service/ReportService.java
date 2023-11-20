package com.microdoc.service;

import com.microdoc.pojo.dto.ReportPageQueryDTO;
import com.microdoc.pojo.dto.ReportUploadDTO;
import com.microdoc.pojo.po.Report;
import com.microdoc.pojo.po.ReportData;
import com.microdoc.pojo.result.PageResult;
import com.microdoc.pojo.vo.ReportDataVO;
import com.microdoc.pojo.vo.ReportVO;

import java.util.List;

public interface ReportService {

    /**
     * 上传报告
     * @param reportUploadDTO
     * @return
     */
    void insert(ReportUploadDTO reportUploadDTO);

    /**
     * 根据用户id查询报告列表
     * @param userId
     * @return
     */
    List<Report> list(Long userId);

    /**
     * 根据报告id查询
     * @param id
     * @return
     */
    ReportVO findById(Long id);

    /**
     * 根据部分条件查询
     * @param reportData
     * @return
     */
    ReportDataVO find(ReportData reportData);

    /**
     * 分页查询
     * @param reportPageQueryDTO
     * @return
     */
    PageResult pageQuery(ReportPageQueryDTO reportPageQueryDTO);

    /**
     * 根据id删除报告
     * @param ids
     */
    void deleteById(List<Long> ids);
}
