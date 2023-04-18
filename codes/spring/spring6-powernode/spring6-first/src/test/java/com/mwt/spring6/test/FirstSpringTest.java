package com.mwt.spring6.test;

import com.mwt.spring6.bean.Person;
import com.mwt.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {



    @Test
    public void testThreadScope() {
        // 这个线程中的两个 bean 是同一个对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        // 启动一个新的线程
        // 这个线程中的两个 bean 是同一个对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb2);
                SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb3);
            }
        }).start();
    }

    @Test
    public void testProperties() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        Person personBean = applicationContext.getBean("personBean", Person.class);

        System.out.println(personBean);

    }


    @Test
    public void testSpringCode() {

        // ApplicationContext 翻译为：应用上下文，其实就是 Spring 容器
        // 它是一个接口
        // ApplicationContext 接口下有很多实现类，其中有一个实现类叫做：ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext：专门从类路径中加载spring配置文件的一个上下文对象
        // 这行代码只要执行，就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器中。
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml", "beans.xml", "xml/beans.xml");
        // Spring的IOC容器实际上使用了：工厂模式
        // Spring底层的IOC是怎么实现的？XML解析 + 工厂模式 + 反射机制



        Object bean = context.getBean("userBean");
        System.out.println(bean);

        Object bean1 = context.getBean("userDao");
        System.out.println(bean1);

        Object bean2 = context.getBean("vipBean");
        System.out.println(bean2);

        Object bean3 = context.getBean("vipBean2");
        System.out.println(bean3);

        Date bean4 = context.getBean("nowTime", Date.class);
        System.out.println(bean4);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format = sdf.format(bean4);
        System.out.println(format);


    }
}
