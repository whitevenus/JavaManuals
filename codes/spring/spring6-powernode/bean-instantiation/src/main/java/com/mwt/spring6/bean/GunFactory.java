package com.mwt.spring6.bean;

/**
 * 具体工厂角色
 */
public class GunFactory {

    /**
     * 实例方法
     * 实际上new对象还是程序员自己手动进行的
     * @return
     */
    public Gun get() {
        return new Gun();
    }
}
