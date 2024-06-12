package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.SpecialistSubject;

public interface SpecialistSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecialistSubject record);

    int insertSelective(SpecialistSubject record);

    SpecialistSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecialistSubject record);

    int updateByPrimaryKey(SpecialistSubject record);
}