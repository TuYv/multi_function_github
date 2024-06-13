package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.Subject;
import com.longbig.multifunction.up.SubjectMapping;
import com.longbig.multifunction.up.service.SubjectMappingService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* 专业mapping表(subject_mapping)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/subjectMapping")
public class SubjectMappingController {
/**
* 服务对象
*/
    @Autowired
    private SubjectMappingService subjectMappingService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SubjectMapping selectOne(Integer id) {
    return subjectMappingService.selectByPrimaryKey(id);
    }

//    /**
//     * 模糊查询专业
//     * @param keyWord
//     * @return
//     */
//    public List<Subject> getSubject(String keyWord) {
//
//    }

}
