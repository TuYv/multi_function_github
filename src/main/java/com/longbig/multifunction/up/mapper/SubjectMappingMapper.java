package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.SubjectMapping;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectMappingMapper {
    List<SubjectMapping> queryAll();
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectMapping record);

    int insertSelective(SubjectMapping record);

    SubjectMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectMapping record);

    int updateByPrimaryKey(SubjectMapping record);

    List<SubjectMapping> queryMappingBySpecialistCode(String specialistCode);
    List<SubjectMapping> queryMappingBySpecialistName(String specialistName);

}