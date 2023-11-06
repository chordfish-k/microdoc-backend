package com.microdoc.service.impl;

import com.microdoc.constants.MessageConstant;
import com.microdoc.context.UserContext;
import com.microdoc.exception.NoSuchReportException;
import com.microdoc.mapper.ReportCaptureMapper;
import com.microdoc.mapper.ReportDataMapper;
import com.microdoc.mapper.ReportMapper;
import com.microdoc.pojo.dto.ReportUploadDTO;
import com.microdoc.pojo.po.Report;
import com.microdoc.pojo.po.ReportCapture;
import com.microdoc.pojo.po.ReportData;
import com.microdoc.pojo.vo.ReportDataVO;
import com.microdoc.pojo.vo.ReportVO;
import com.microdoc.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;
    private final ReportDataMapper reportDataMapper;
    private final ReportCaptureMapper reportCaptureMapper;
    /**
     * 上传报告
     * @param reportUploadDTO
     * @return
     */
    @Override
    public void insert(ReportUploadDTO reportUploadDTO) {
        // 插入一条报告
        Long userId = UserContext.getCurrentId();
        Report report = Report.builder()
                .userId(userId)
                .uploadTime(LocalDateTime.now())
                .build();
        reportMapper.insert(report);

        // 插入多条报告数据
        List<ReportData> dataList = reportUploadDTO.getDatas().stream().map(d -> {
            ReportData reportData = new ReportData();
            BeanUtils.copyProperties(d, reportData);
            reportData.setReportId(report.getId());
            return reportData;
        }).collect(Collectors.toList());
        reportDataMapper.insertBatch(dataList);
    }

    /**
     * 根据用户id查询报告列表
     * @param userId
     * @return
     */
    @Override
    public List<Report> list(Long userId) {
        return reportMapper.list(userId);
    }

    /**
     * 根据id查询报告
     * @param id
     * @return
     */
    @Override
    public ReportVO findById(Long id) {
        Report report = reportMapper.findById(id);
        if (!Objects.equals(report.getUserId(), UserContext.getCurrentId())) {
            // 如果不是用户自己的，抛出业务异常
            throw new NoSuchReportException(MessageConstant.DATA_ACCESS_DENIED);
        }
        // 根据reportId查询详细数据
        List<ReportData> reportDataList = reportDataMapper.findByReportId(report.getId());
        // 查询捕获数据
        List<ReportCapture> reportCaptureList = reportCaptureMapper.findByReportId(report.getId());

        // 组装数据
        ReportVO reportVO = new ReportVO();
        BeanUtils.copyProperties(report, reportVO);
        reportVO.setDatas(reportDataList);
        reportVO.setCaptures(reportCaptureList);
        return reportVO;
    }

    /**
     * 根报告id和数据类型查询
     * @param reportData
     * @return
     */
    @Override
    public ReportDataVO find(ReportData reportData) {
        reportData = reportDataMapper.find(reportData);
        ReportDataVO reportDataVO = new ReportDataVO();
        BeanUtils.copyProperties(reportData, reportDataVO);
        return reportDataVO;
    }
}
