package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.SubjectMapping;
import com.longbig.multifunction.up.mapper.SubjectMappingMapper;
@Service
public class SubjectMappingService{

    @Autowired
    private SubjectMappingMapper subjectMappingMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return subjectMappingMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SubjectMapping record) {
        return subjectMappingMapper.insert(record);
    }

    
    public int insertSelective(SubjectMapping record) {
        return subjectMappingMapper.insertSelective(record);
    }

    
    public SubjectMapping selectByPrimaryKey(Integer id) {
        return subjectMappingMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SubjectMapping record) {
        return subjectMappingMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SubjectMapping record) {
        return subjectMappingMapper.updateByPrimaryKey(record);
    }

}
