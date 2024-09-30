package com.longbig.multifunction.up.controller;
import com.longbig.multifunction.up.Subject;
import com.longbig.multifunction.up.SubjectClassDTO;
import com.longbig.multifunction.up.SubjectMapping;
import com.longbig.multifunction.up.service.SubjectMappingService;
import java.util.Set;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* 专业mapping表(subject_mapping)表控制层
*
* @author xxxxx
*/
@CrossOrigin
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

    /**
     * 根据专科类查询关联的本科类
     * @param classDTO
     * @return
     */
    @PostMapping("queryMappingBySpecialist")
    public Set<SubjectClassDTO> queryMappingBySpecialist(@RequestBody SubjectClassDTO classDTO) {
        return subjectMappingService.queryMappingBySpecialist(classDTO);
    }

}
