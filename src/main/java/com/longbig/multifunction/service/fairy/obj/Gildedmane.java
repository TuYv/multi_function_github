package com.longbig.multifunction.service.fairy.obj;

import lombok.Data;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 金马
 * @create 2023-08-22 18:50
 **/
public class Gildedmane extends Player{

    public Gildedmane(String no, boolean order) {
        this.setNo(no);
        this.setName("金马");
        this.setSkill1(new Sprint());
        this.setSkill2(new Rotation());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "jzu" : "jco";
    }
}
