package com.microdoc.mapper;

import com.microdoc.pojo.po.Report;
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
    @Select("select * from report where user_id=#{userId}")
    List<Report> list(Long userId);

    /**
     * 根据id查询报告
     * @param id
     * @return
     */
    @Select("select * from report where id=#{id}")
    Report findById(Long id);
}
