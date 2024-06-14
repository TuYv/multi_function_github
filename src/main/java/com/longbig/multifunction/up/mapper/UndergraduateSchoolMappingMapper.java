package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.UndergraduateSchoolMapping;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UndergraduateSchoolMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UndergraduateSchoolMapping record);

    int insertSelective(UndergraduateSchoolMapping record);

    UndergraduateSchoolMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UndergraduateSchoolMapping record);

    int updateByPrimaryKey(UndergraduateSchoolMapping record);
}