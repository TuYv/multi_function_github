package com.longbig.multifunction.up;

import java.util.Date;

/**
 * 专业院校mapping表
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUndergraduateClassCode() {
        return undergraduateClassCode;
    }

    public void setUndergraduateClassCode(String undergraduateClassCode) {
        this.undergraduateClassCode = undergraduateClassCode;
    }

    public String getUndergraduateClassName() {
        return undergraduateClassName;
    }

    public void setUndergraduateClassName(String undergraduateClassName) {
        this.undergraduateClassName = undergraduateClassName;
    }

    public String getUndergraduateSubjectCode() {
        return undergraduateSubjectCode;
    }

    public void setUndergraduateSubjectCode(String undergraduateSubjectCode) {
        this.undergraduateSubjectCode = undergraduateSubjectCode;
    }

    public String getUndergraduateSubjectName() {
        return undergraduateSubjectName;
    }

    public void setUndergraduateSubjectName(String undergraduateSubjectName) {
        this.undergraduateSubjectName = undergraduateSubjectName;
    }

    public String getUndergraduateSchoolName() {
        return undergraduateSchoolName;
    }

    public void setUndergraduateSchoolName(String undergraduateSchoolName) {
        this.undergraduateSchoolName = undergraduateSchoolName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}