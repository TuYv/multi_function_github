package com.longbig.multifunction.up.service;

import cn.hutool.core.collection.CollectionUtil;
import com.longbig.multifunction.up.SubjectClassDTO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    public Set<SubjectClassDTO> queryMappingBySpecialist(SubjectClassDTO classDTO) {
        List<SubjectMapping> subjectList1 = subjectMappingMapper.queryMappingBySpecialistCode(classDTO.getClassCode());
        List<SubjectMapping> subjectList2 = subjectMappingMapper.queryMappingBySpecialistName(classDTO.getClassName());

        Set<SubjectClassDTO> set1 = subjectList1.stream()
            .map(SubjectClassDTO::fromUndergraduate)
            .collect(Collectors.toSet());

        Set<SubjectClassDTO> set2 = subjectList2.stream().map(SubjectClassDTO::fromUndergraduate).collect(Collectors.toSet());
        if (CollectionUtil.isNotEmpty(set1)) {
            set1.addAll(set2);
            return set1;
        } else {
            return set2;
        }
    }

}
