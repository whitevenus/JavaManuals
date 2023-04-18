package com.mwt.simple.factory;

/**
 * 客户端程序：测试用
 */
public class Test {

    public static void main(String[] args) {

        // 对于客户端来讲，具体产品的生产细节不需要关注，只需要向工厂索要即可。
        // 客户端只负责消费，工厂类负责生产。生产者和消费者分离了。
        // 简单工厂模式的作用：职责分离，客户端不需要关注产品的生产细节

        // 需要坦克
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        // 需要匕首
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        // 需要战斗机
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();



    }
}
