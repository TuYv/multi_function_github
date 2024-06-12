package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.SubjectMapping;

public interface SubjectMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectMapping record);

    int insertSelective(SubjectMapping record);

    SubjectMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectMapping record);

    int updateByPrimaryKey(SubjectMapping record);
}