package com.mwt.reflect;

import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws Exception {

        // 使用反射机制调用方法
        /**
         * 第一要素：哪个对象
         * 第二要素：要调用的方法
         * 第三要素：要传的参数
         * 第三要素：方法返回值
         */
        // 获取Class类对象
        Class<SomeService> someServiceClass = SomeService.class;
        // 获取指定方法
        Method doSome = someServiceClass.getDeclaredMethod("doSome", String.class, int.class);
        // 实例化对象
        SomeService someService = someServiceClass.getDeclaredConstructor().newInstance();
        // 执行方法
        Object s = doSome.invoke(someService, "李四", 250);
        // 输出方法返回值
        System.out.println(s);

    }
}
