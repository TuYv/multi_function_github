package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 猴子
 * @create 2023-08-22 19:15
 **/
public class Caco extends Player{

    public Caco(String no, boolean order) {
        this.setNo(no);
        this.setName("猴子");
        this.setSkill1(new HeavyBlow());
        this.setSkill2(new Healing());
        if (!order) {
            changeSkill();
        }
        this.setSkillOrder(order);
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "czi" : "czo";
    }
}
