package com.mwt.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {

    public static void main(String[] args) throws Exception{

        /**
         * 需求：
         *      假设现在已知以下信息
         *          1. 有这样一个类，类名叫做：com.mwt.reflect.User
         *          2. 这个类符合javaBean，属性私有化，对外提供公开的 setter 和 getter 方法
         *          3. 这个类当中有一个 age 属性
         *          4. age 的属性的类型是 int 类型。
         *      请使用反射机制调用相关方法，给 User 对象的 age 属性赋值。
         */

        String className = "com.mwt.reflect.User";
        String propertyName = "age";

        // 通过反射机制调用setAge()方法
        Class<?> aClass = Class.forName(className);
        // 拼接方法名
        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
        // 获取属性
        Field declaredField = aClass.getDeclaredField(propertyName);
//        System.out.println(declaredField);
        Method setAge = aClass.getDeclaredMethod(methodName, declaredField.getType());

        Object o = aClass.getDeclaredConstructor().newInstance();
        setAge.invoke(o, 18);

        System.out.println(o);

    }
}
