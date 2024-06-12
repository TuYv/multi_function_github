package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.UndergraduateSubject;
import com.longbig.multifunction.up.mapper.UndergraduateSubjectMapper;
@Service
public class UndergraduateSubjectService{

    @Autowired
    private UndergraduateSubjectMapper undergraduateSubjectMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return undergraduateSubjectMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UndergraduateSubject record) {
        return undergraduateSubjectMapper.insert(record);
    }

    
    public int insertSelective(UndergraduateSubject record) {
        return undergraduateSubjectMapper.insertSelective(record);
    }

    
    public UndergraduateSubject selectByPrimaryKey(Integer id) {
        return undergraduateSubjectMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UndergraduateSubject record) {
        return undergraduateSubjectMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UndergraduateSubject record) {
        return undergraduateSubjectMapper.updateByPrimaryKey(record);
    }

}
