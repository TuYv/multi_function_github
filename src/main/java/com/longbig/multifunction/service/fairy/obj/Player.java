package com.longbig.multifunction.service.fairy.obj;

import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description
 * @create 2023-08-22 13:59
 **/
@Data
public class Player {
    private String no;
    private String name;
    private Skill skill1;
    private Skill skill2;
    /**
     * true 正序
     */
    private boolean skillOrder;
    private Integer position = 0;
    private boolean isHide = true;
    private double rank1 = 0.0;
    private double rank2 = 0.0;
    private double rank3 = 0.0;

    public void changeSkill() {
        Skill skill = new Skill();
        skill.setName(skill1.getName());
        skill.setCnName(skill1.getCnName());
        skill.setOrder(skill1.getOrder());
        this.skill1 = skill2;
        skill2 = skill;
    }
    public void print() {
        String format = String.format("编号:%-3s名字:%-5s技能1:%-3s技能2:%-3s", this.getNo(), this.getName(), this.getSkill1().getCnName(),
            this.getSkill2().getCnName());
        System.out.println(format);
    }
    public String printRank1() {
        String format = String.format("%-3s第一轮胜率%.2f%%", this.getName(), this.getRank1() * 100);
        System.out.println(format);
        return format;
    }
    public String printRank2() {
        String format = String.format("%-3s第二轮胜率%.2f%%", this.getName(), this.getRank2() * 100);
        System.out.println(format);
        return format;
    }
    public String printRank3() {
        String format = String.format("%-3s第三轮胜率%.2f%%", this.getName(), this.getRank3() * 100);
        System.out.println(format);
        return format;
    }
    public String getBro() {
        if (skillOrder) {
            return this.no.substring(0,2) + "2";
        } else {
            return this.no.substring(0,2) + "1";
        }
    }
}
