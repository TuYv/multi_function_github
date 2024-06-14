package com.longbig.multifunction.up;

import lombok.Data;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 专业类DTO
 * @create 2024-06-13 23:57
 **/
@Data
public class SubjectClassDTO {

    /**
     * 专业类名称
     */
    private String className;
    /**
     * 专业类code
     */
    private String classCode;

    public static SubjectClassDTO from(SpecialistSubject subject) {
        SubjectClassDTO classDTO = new SubjectClassDTO();
        classDTO.setClassName(subject.getClassName());
        classDTO.setClassCode(subject.getClassCode());

        return classDTO;
    }

    public static SubjectClassDTO fromUndergraduate(SubjectMapping subjectMapping) {
        SubjectClassDTO classDTO = new SubjectClassDTO();
        classDTO.setClassName(subjectMapping.getUndergraduateName());
        classDTO.setClassCode(subjectMapping.getUndergraduateCode());

        return classDTO;
    }
}
