package com.mwt.spring6.bean;

import java.util.Properties;

public class Person {

    // 注入属性类
    // Properties 本质上也是一个 Map 集合
    // Properties 父类 Hashtable 实现了 Map 接口
    // 虽然它是一个Map集合，但是和Map注入方式不同
    // Properties的key和value只能是String类型
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "properties=" + properties +
                '}';
    }
}
