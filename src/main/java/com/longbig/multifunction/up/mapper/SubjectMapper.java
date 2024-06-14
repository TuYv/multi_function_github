package com.longbig.multifunction.up.mapper;

import com.longbig.multifunction.up.Subject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}