package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.Subject;
import com.longbig.multifunction.up.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 专业表(subject)表控制层
*
* @author xxxxx
*/
@CrossOrigin
@RestController
@RequestMapping("/subject")
public class SubjectController {
/**
* 服务对象
*/
    @Autowired
    private SubjectService subjectService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Subject selectOne(Long id) {
    return subjectService.selectByPrimaryKey(id);
    }

}
