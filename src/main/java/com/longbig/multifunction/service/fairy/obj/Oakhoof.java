package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 木马
 * @create 2023-08-22 19:08
 **/
public class Oakhoof extends Player{

    public Oakhoof(String no, boolean order) {

        this.setNo(no);
        this.setName("木马");
        this.setSkill1(new Sprint());
        this.setSkill2(new Protection());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "mbo" : "mco";
    }
}
