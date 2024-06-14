package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 狮子
 * @create 2023-08-22 19:17
 **/
public class Tiger extends Player{

    public Tiger(String no, boolean order) {
        this.setNo(no);
        this.setName("老虎");
        this.setSkill1(new Protection());
        this.setSkill2(new Healing());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "hzi" : "hbo";
    }
}
