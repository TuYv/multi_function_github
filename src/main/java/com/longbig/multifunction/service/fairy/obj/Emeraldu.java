package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 绿马
 * @create 2023-08-22 19:09
 **/
public class Emeraldu extends Player{

    public Emeraldu(String no, boolean order) {
        this.setNo(no);
        this.setName("绿马");
        this.setSkill1(new Sprint());
        this.setSkill2(new Healing());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "lzi" : "lco";
    }
}
