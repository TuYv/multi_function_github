package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 熊猫
 * @create 2023-08-22 19:16
 **/
public class Panda extends Player{

    public Panda(String no, boolean order) {
        this.setNo(no);
        this.setName("熊猫");
        this.setSkill1(new Dodge());
        this.setSkill2(new Healing());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "xzi" : "xsa";
    }
}
