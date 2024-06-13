package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.SubjectMapping;

import java.util.List;

public interface SubjectMappingMapper {
    List<SubjectMapping> queryAll();
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectMapping record);

    int insertSelective(SubjectMapping record);

    SubjectMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectMapping record);

    int updateByPrimaryKey(SubjectMapping record);
}