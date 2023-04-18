package com.mwt.reflect;

import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) throws Exception{

        Class<?> aClass = Class.forName("com.mwt.reflect.SomeService");

        Method doSome = aClass.getDeclaredMethod("doSome");

        Object obj = aClass.getDeclaredConstructor().newInstance();
        doSome.invoke(obj);
    }
}
