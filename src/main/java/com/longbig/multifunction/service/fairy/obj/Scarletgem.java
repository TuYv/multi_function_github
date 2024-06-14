package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 红马
 * @create 2023-08-22 19:06
 **/
public class Scarletgem extends Player{

    public Scarletgem(String no, boolean order) {
        this.setNo(no);
        this.setName("红马");
        this.setSkill1(new Sprint());
        this.setSkill2(new HeavyBlow());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "hzo" : "hco";
    }
}
