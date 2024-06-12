package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.SpecialistSubject;
import com.longbig.multifunction.up.service.SpecialistSubjectService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 专科专业表(specialist_subject)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/specialist_subject")
public class SpecialistSubjectController {
/**
* 服务对象
*/
    @Autowired
    private SpecialistSubjectService specialistSubjectService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public SpecialistSubject selectOne(Integer id) {
    return specialistSubjectService.selectByPrimaryKey(id);
    }

}
