package com.mwt.spring6.bean;

public class User {

    // Spring是怎么实例化对象的？
    // 默认情况下，Spring会通过反射机制，调用类的无参构造方法来实例化对象
    // 实现原理如下：
    //          Class clazz = Class.forName("com.mwt.spring6.bean.User");
    //          Object obj = clazz.getConstructor().newInstance();

    private String name;

    private String className;

    public User() {
        System.out.println("User的无参数构造方法执行");
    }

    public User(String name, String className) {
        this.name = name;
        this.className = className;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
