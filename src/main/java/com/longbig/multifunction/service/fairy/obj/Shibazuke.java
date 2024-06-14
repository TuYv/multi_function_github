package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 狗子
 * @create 2023-08-22 19:16
 **/
public class Shibazuke extends Player{

    public Shibazuke(String no, boolean order) {
        this.setNo(no);
        this.setName("狗子");
        this.setSkill1(new Dodge());
        this.setSkill2(new Protection());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "gbo" : "gsa";
    }
}
