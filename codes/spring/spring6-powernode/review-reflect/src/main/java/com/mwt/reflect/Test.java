package com.mwt.reflect;

public class Test {

    public static void main(String[] args) {

        // 不使用反射机制调用这些方法
        /**
         * 调用一个方法应该含有哪些要素：
         * 第一要素：调用哪个对象
         * 第二要素：调用哪个方法
         * 第三要素：调用方法的时候传什么参数
         * 第四要素：方法执行结束之后的返回结果
         *
         * 调用哪个对象的哪个方法，传什么参数，返回什么值。
         *
         * 即使使用反射机制调用方法，也同样需要这四个要素
         */
        SomeService someService = new SomeService();
        someService.doSome();
        String s1 = someService.doSome("张三");
        System.out.println(s1);
        String s2 = someService.doSome("李四", 250);
        System.out.println(s2);


    }



}
