package com.microdoc.mapper;

import com.github.pagehelper.Page;
import com.microdoc.pojo.dto.ReportPageQueryDTO;
import com.microdoc.pojo.po.Report;
import com.microdoc.pojo.vo.ReportVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper {
    /**
     * 插入单条报告
     * @param report
     */
    void insert(Report report);

    /**
     * 根据用户id查询所有报告
     * @return
     */
    @Select("select * from report where user_id=#{userId} order by upload_time desc")
    List<Report> list(Long userId);

    /**
     * 根据id查询报告
     * @param id
     * @return
     */
    @Select("select * from report where id=#{id}")
    Report findById(Long id);

    /**
     * 报告分页查询
     * @param reportPageQueryDTO
     * @return
     */
    Page<Report> pageQuery(ReportPageQueryDTO reportPageQueryDTO);

    /**
     * 根据id批量删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);
}
