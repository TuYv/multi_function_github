package com.longbig.multifunction.service.fairy.obj;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 蓝马
 * @create 2023-08-22 19:09
 **/
public class ArcanaCrest extends Player{

    public ArcanaCrest(String no, boolean order) {
        this.setNo(no);
        this.setName("蓝马");
        this.setSkill1(new Rotation());
        this.setSkill2(new HeavyBlow());
        if (!order) {
            changeSkill();
        }

        this.setSkillOrder(order);
    }

    @Override
    public String getBro() {
        return this.isSkillOrder() ? "lzo" : "lzu";
    }
}
