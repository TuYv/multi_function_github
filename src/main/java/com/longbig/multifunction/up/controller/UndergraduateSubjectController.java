package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.UndergraduateSubject;
import com.longbig.multifunction.up.service.UndergraduateSubjectService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 本科专业表(undergraduate_subject)表控制层
*
* @author xxxxx
*/
@CrossOrigin
@RestController
@RequestMapping("/undergraduate_subject")
public class UndergraduateSubjectController {
/**
* 服务对象
*/
    @Autowired
    private UndergraduateSubjectService undergraduateSubjectService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public UndergraduateSubject selectOne(Integer id) {
    return undergraduateSubjectService.selectByPrimaryKey(id);
    }

}
