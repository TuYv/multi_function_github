package com.longbig.multifunction.up;

import java.util.Date;

/**
 * 专业mapping表
 */
public class SubjectMapping {
    private Integer id;

    /**
    * 本科专业类code
    */
    private String undergraduateCode;

    /**
    * 本科专业类名称
    */
    private String undergraduateName;

    /**
    * 专科专业类code
    */
    private String specialistCode;

    /**
    * 专科专业类名称
    */
    private String specialistName;

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

    public String getUndergraduateCode() {
        return undergraduateCode;
    }

    public void setUndergraduateCode(String undergraduateCode) {
        this.undergraduateCode = undergraduateCode;
    }

    public String getUndergraduateName() {
        return undergraduateName;
    }

    public void setUndergraduateName(String undergraduateName) {
        this.undergraduateName = undergraduateName;
    }

    public String getSpecialistCode() {
        return specialistCode;
    }

    public void setSpecialistCode(String specialistCode) {
        this.specialistCode = specialistCode;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
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