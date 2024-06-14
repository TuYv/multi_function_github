package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 猫头鹰
 * @create 2023-08-22 19:14
 **/
public class Dakila extends Player{

    public Dakila(String no, boolean order) {
        this.setNo(no);
        this.setName("猫头鹰");
        this.setSkill1(new HeavyBlow());
        this.setSkill2(new Protection());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "ybo" : "yzo";
    }
}
