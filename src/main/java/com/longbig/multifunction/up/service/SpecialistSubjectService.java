package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.SpecialistSubject;
import com.longbig.multifunction.up.mapper.SpecialistSubjectMapper;

import java.util.List;

@Service
public class SpecialistSubjectService{

    @Autowired
    private SpecialistSubjectMapper specialistSubjectMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return specialistSubjectMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SpecialistSubject record) {
        return specialistSubjectMapper.insert(record);
    }

    
    public int insertSelective(SpecialistSubject record) {
        return specialistSubjectMapper.insertSelective(record);
    }

    
    public SpecialistSubject selectByPrimaryKey(Integer id) {
        return specialistSubjectMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SpecialistSubject record) {
        return specialistSubjectMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SpecialistSubject record) {
        return specialistSubjectMapper.updateByPrimaryKey(record);
    }

    public List<SpecialistSubject> queryByKeyword(String key) {
        return specialistSubjectMapper.queryByKeyword(key);
    }

}
