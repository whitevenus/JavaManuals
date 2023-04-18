package com.mwt.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("1. 无参数构造方法执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 给对象的属性赋值");
        this.name = name;
    }

    public void init() {
        System.out.println("3. 对象的初始化方法执行");
    }

    public void destroyBean() {
        System.out.println("5. 对象的销毁方法执行");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean这个类的加载器是：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("这个Bean的名字是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet 方法执行了");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 的 destroy 方法执行了");
    }
}
