package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 牛牛
 * @create 2023-08-22 19:13
 **/
public class Fury extends Player {

    public Fury(String no, boolean order) {
        this.setNo(no);
        this.setName("牛牛");
        this.setSkill1(new HeavyBlow());
        this.setSkill2(new Dodge());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "nsa" : "nzo";
    }
}
