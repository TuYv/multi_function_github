package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.UndergraduateSubject;

public interface UndergraduateSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UndergraduateSubject record);

    int insertSelective(UndergraduateSubject record);

    UndergraduateSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UndergraduateSubject record);

    int updateByPrimaryKey(UndergraduateSubject record);
}