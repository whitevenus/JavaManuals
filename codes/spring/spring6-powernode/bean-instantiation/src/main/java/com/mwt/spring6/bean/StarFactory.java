package com.mwt.spring6.bean;

/**
 * 简单工厂模式中的工厂类角色。
 */
public class StarFactory {

    /**
     * 静态方法
     * @return
     */
    public static Star get() {
        // 实际上创建的时候是程序员负责new的
        return new Star();
    }
}
