package com.longbig.multifunction.up.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.longbig.multifunction.up.School;
import com.longbig.multifunction.up.mapper.SchoolMapper;
@Service
public class SchoolService{

    @Autowired
    private SchoolMapper schoolMapper;

    
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

}
