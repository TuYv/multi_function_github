package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 狗熊
 * @create 2023-08-22 19:11
 **/
public class Shardik extends Player{

    public Shardik(String no, boolean order) {
        this.setNo(no);
        this.setName("狗熊");
        this.setSkill1(new Rotation());
        this.setSkill2(new Protection());
        this.setSkillOrder(order);
        if (!order) {
            changeSkill();
        }
    }
    @Override
    public String getBro() {
        return this.isSkillOrder() ? "xbo" : "xzu";
    }
}
