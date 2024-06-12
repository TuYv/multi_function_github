package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.School;
import com.longbig.multifunction.up.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 学院表(school)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/school")
public class SchoolController {
/**
* 服务对象
*/
    @Autowired
    private SchoolService schoolService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public School selectOne(Integer id) {
    return schoolService.selectByPrimaryKey(id);
    }

}
