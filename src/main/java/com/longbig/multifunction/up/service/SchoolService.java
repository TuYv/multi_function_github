package com.longbig.multifunction.up.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.longbig.multifunction.up.UndergraduateSchoolMapping;
import com.longbig.multifunction.up.mapper.UndergraduateSchoolMappingMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.School;
import com.longbig.multifunction.up.mapper.SchoolMapper;

import javax.annotation.Resource;

@Service
public class SchoolService{

    @Autowired
    private SchoolMapper schoolMapper;
    @Resource private UndergraduateSchoolMappingMapper undergraduateSchoolMappingMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return schoolMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(School record) {
        return schoolMapper.insert(record);
    }

    
    public int insertSelective(School record) {
        return schoolMapper.insertSelective(record);
    }

    
    public School selectByPrimaryKey(Integer id) {
        return schoolMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(School record) {
        return schoolMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(School record) {
        return schoolMapper.updateByPrimaryKey(record);
    }


    /**
     * 根据关联表绕一圈
     * @param className
     * @return
     */
    public List<School> queryByClassName(String className) {
        List<UndergraduateSchoolMapping> schoolMappingList = undergraduateSchoolMappingMapper.queryByClassName(className);
        if (CollectionUtil.isNotEmpty(schoolMappingList)) {
            return schoolMappingList.stream()
                    .map(mapping -> schoolMapper.queryBySubjectAndName(mapping.getUndergraduateSubjectName(), mapping.getUndergraduateSchoolName()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

}
