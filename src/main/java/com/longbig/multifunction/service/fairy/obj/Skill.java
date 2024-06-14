package com.longbig.multifunction.service.fairy.obj;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 技能
 * @create 2023-08-22 14:00
 **/
@Data
public class Skill {

    /**
     * 名称
     */
    private String name;
    private String cnName;
    /**
     * 顺序
     */
    private int order;
}
