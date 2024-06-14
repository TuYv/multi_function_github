package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.School;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    List<School> queryByClassName(String className);
}