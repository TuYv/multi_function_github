package com.longbig.multifunction.up;

import lombok.Data;

import java.util.Date;

/**
 * 专业院校mapping表
 */
@Data
public class UndergraduateSchoolMapping {
    private Integer id;

    /**
    * 本科专业类code
    */
    private String undergraduateClassCode;

    /**
    * 本科专业类名称
    */
    private String undergraduateClassName;

    /**
    * 本科专业code
    */
    private String undergraduateSubjectCode;

    /**
    * 本科专业名称
    */
    private String undergraduateSubjectName;

    /**
    * 本科院校
    */
    private String undergraduateSchoolName;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 是否删除
    */
    private Byte deleted;
}