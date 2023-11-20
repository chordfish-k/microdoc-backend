package com.microdoc.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportPageQueryDTO implements Serializable {
    //用户id
    private long userId;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;
}
