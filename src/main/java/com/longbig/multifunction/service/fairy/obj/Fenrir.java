package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 野狼
 * @create 2023-08-22 19:12
 **/
public class Fenrir extends Player{

    public Fenrir(String no, boolean order) {
        this.setNo(no);
        this.setName("野狼");
        this.setSkill1(new Rotation());
        this.setSkill2(new Healing());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "nzi" : "nzu";
    }
}
