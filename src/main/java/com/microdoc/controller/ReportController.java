package com.microdoc.controller;

import com.microdoc.context.UserContext;
import com.microdoc.pojo.dto.ReportDataQueryDTO;
import com.microdoc.pojo.dto.ReportUploadDTO;
import com.microdoc.pojo.po.Report;
import com.microdoc.pojo.po.ReportData;
import com.microdoc.pojo.result.Result;
import com.microdoc.pojo.vo.ReportDataVO;
import com.microdoc.pojo.vo.ReportVO;
import com.microdoc.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@Api(tags = "报告管理相关接口")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    /**
     * 上传报告
     * @param reportUploadDTO
     * @return
     */
    @PostMapping
    @ApiOperation("上传报告")
    public Result insert(@RequestBody ReportUploadDTO reportUploadDTO) {
        log.info("上传报告：{}", reportUploadDTO);
        reportService.insert(reportUploadDTO);
        return Result.success();
    }

    /**
     * 查询报告列表
     * @return
     */
    @GetMapping
    @ApiOperation("查询报告列表")
    public Result<List<Report>> list() {
        Long userId = UserContext.getCurrentId();
        log.info("查询报告列表, userId={}", userId);
        List<Report> reportList = reportService.list(userId);
        return Result.success(reportList);
    }

    /**
     * 根据id查询报告
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询报告")
    public Result<ReportVO> findById(@PathVariable Long id) {
        log.info("根据id查询报告, reportId={}", id);
        ReportVO report = reportService.findById(id);
        return Result.success(report);
    }

    /**
     * 根据报告id和数据类型查询数据
     * @param reportDataQueryDTO
     * @return
     */
    @GetMapping("/detail")
    @ApiOperation("根据报告id和数据类型查询数据")
    public Result<ReportDataVO> findByReportIdAndType(@RequestBody ReportDataQueryDTO reportDataQueryDTO) {
        log.info("根据报告id和数据类型查询数据：{}", reportDataQueryDTO);
        ReportData reportData = new ReportData();
        BeanUtils.copyProperties(reportDataQueryDTO, reportData);
        ReportDataVO reportDataVO = reportService.find(reportData);
        return Result.success(reportDataVO);
    }
}
