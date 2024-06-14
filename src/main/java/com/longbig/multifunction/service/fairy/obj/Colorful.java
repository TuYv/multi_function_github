package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 草泥马
 * @create 2023-08-22 19:10
 **/
public class Colorful extends Player{

    public Colorful(String no, boolean order) {
        this.setNo(no);
        this.setName("草泥马");
        this.setSkill1(new Rotation());
        this.setSkill2(new Dodge());
        if (!order) {
            changeSkill();
        }
        this.setSkillOrder(order);
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "csa" : "czu";
    }
}
