package com.longbig.multifunction.up;

/**
 * 专科专业表
 */
public class SpecialistSubject {
    private Integer id;

    /**
    * 专业类名称
    */
    private String className;

    /**
    * 专业名称
    */
    private String name;

    /**
    * 专业code
    */
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}