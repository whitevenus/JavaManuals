package com.mwt.factory.method;

/**
 * 抽象工厂角色
 */
public abstract class WeaponFactory {

    /**
     * 这个方法就不是静态的了，是实例方法
     * @return
     */
    public abstract Weapon get();
}
