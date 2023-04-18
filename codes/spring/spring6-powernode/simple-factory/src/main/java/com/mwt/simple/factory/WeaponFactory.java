package com.mwt.simple.factory;


/**
 * 工厂类角色
 */
public class WeaponFactory {


    /**
     * 静态方法：要获取具体的产品，就传入相对应的参数，例如：传 TANK 获取坦克，传 DAGGER 获取匕首
     * 简单工厂模式有一个静态方法，所以被称为静态工厂方法模式
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType) {
        if (weaponType.equals("TANK")) {
            return new Tank();
        } else if (weaponType.equals("DAGGER")) {
            return new Dagger();
        } else if (weaponType.equals("FIGHTER")) {
            return new Fighter();
        } else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
