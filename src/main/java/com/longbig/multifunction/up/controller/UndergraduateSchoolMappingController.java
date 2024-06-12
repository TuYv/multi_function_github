package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.UndergraduateSchoolMapping;
import com.longbig.multifunction.up.service.UndergraduateSchoolMappingService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
* 专业院校mapping表(undergraduate_school_mapping)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/undergraduate_school_mapping")
public class UndergraduateSchoolMappingController {
/**
* 服务对象
*/
    @Autowired
    private UndergraduateSchoolMappingService undergraduateSchoolMappingService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public UndergraduateSchoolMapping selectOne(Integer id) {
    return undergraduateSchoolMappingService.selectByPrimaryKey(id);
    }

}
