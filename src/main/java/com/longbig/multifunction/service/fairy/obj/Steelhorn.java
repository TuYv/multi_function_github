package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 铁马
 * @create 2023-08-22 19:07
 **/
public class Steelhorn extends Player{

    public Steelhorn(String no, boolean order) {
        this.setNo(no);
        this.setName("铁马");
        this.setSkill1(new Sprint());
        this.setSkill2(new Dodge());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "tsa" : "tco";
    }
}
