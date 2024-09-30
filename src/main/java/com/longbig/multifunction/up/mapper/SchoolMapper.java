package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.School;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    School queryBySubjectAndName(@Param("subjectName") String subjectName,@Param("name") String name);

    List<School> queryBySchoolName(@Param("list") Set<String> list);
}