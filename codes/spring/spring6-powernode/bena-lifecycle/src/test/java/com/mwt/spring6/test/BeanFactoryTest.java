package com.mwt.spring6.test;

import com.mwt.spring6.bean.Student;
import com.mwt.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {


    @Test
    public void testRegisterBean() {
        // 自己new的对象
        Student student = new Student();
        System.out.println(student);

        // 将自己new的对象交给spring容器来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", student);

        // 从spring容器中获取bean
        Student studentBean = factory.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    @Test
    public void TestLifecycle() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);

        System.out.println("4. 使用Bean：" + userBean);

        // 必须关闭Spring容器，才会销毁 Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();


    }
}
