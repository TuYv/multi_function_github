package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.Subject;
import com.longbig.multifunction.up.mapper.SubjectMapper;
@Service
public class SubjectService{

    @Autowired
    private SubjectMapper subjectMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return subjectMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Subject record) {
        return subjectMapper.insert(record);
    }

    
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    
    public Subject selectByPrimaryKey(Long id) {
        return subjectMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Subject record) {
        return subjectMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }

}
