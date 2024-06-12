package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.UndergraduateSchoolMapping;
import com.longbig.multifunction.up.mapper.UndergraduateSchoolMappingMapper;
@Service
public class UndergraduateSchoolMappingService{

    @Autowired
    private UndergraduateSchoolMappingMapper undergraduateSchoolMappingMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return undergraduateSchoolMappingMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UndergraduateSchoolMapping record) {
        return undergraduateSchoolMappingMapper.insert(record);
    }

    
    public int insertSelective(UndergraduateSchoolMapping record) {
        return undergraduateSchoolMappingMapper.insertSelective(record);
    }

    
    public UndergraduateSchoolMapping selectByPrimaryKey(Integer id) {
        return undergraduateSchoolMappingMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UndergraduateSchoolMapping record) {
        return undergraduateSchoolMappingMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UndergraduateSchoolMapping record) {
        return undergraduateSchoolMappingMapper.updateByPrimaryKey(record);
    }

}
