package com.longbig.multifunction.up;

import java.util.Date;

/**
 * 学院表
 */
public class School {
    private Integer id;

    /**
    * 院校code
    */
    private String code;

    /**
    * 院校名称
    */
    private String name;

    /**
    * 专业名称
    */
    private String subjectName;

    /**
    * 统考科目1
    */
    private String examA;

    /**
    * 统考科目2
    */
    private String examB;

    /**
    * 专业综合科目
    */
    private String subjectExam;

    /**
    * 加试科目
    */
    private String extendExam;

    /**
    * 2024报考人数
    */
    private String examNum2024;

    /**
    * 2024录取人数
    */
    private String examPassNum2024;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamA() {
        return examA;
    }

    public void setExamA(String examA) {
        this.examA = examA;
    }

    public String getExamB() {
        return examB;
    }

    public void setExamB(String examB) {
        this.examB = examB;
    }

    public String getSubjectExam() {
        return subjectExam;
    }

    public void setSubjectExam(String subjectExam) {
        this.subjectExam = subjectExam;
    }

    public String getExtendExam() {
        return extendExam;
    }

    public void setExtendExam(String extendExam) {
        this.extendExam = extendExam;
    }

    public String getExamNum2024() {
        return examNum2024;
    }

    public void setExamNum2024(String examNum2024) {
        this.examNum2024 = examNum2024;
    }

    public String getExamPassNum2024() {
        return examPassNum2024;
    }

    public void setExamPassNum2024(String examPassNum2024) {
        this.examPassNum2024 = examPassNum2024;
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