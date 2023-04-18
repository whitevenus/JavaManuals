package com.mwt.spring6.test;

import com.mwt.spring6.bean.Gun;
import com.mwt.spring6.bean.Person;
import com.mwt.spring6.bean.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationTest {

    @Test
    public void testInstantiation4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testInstantiation3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gunBean = applicationContext.getBean("gunBean", Gun.class);
        System.out.println(gunBean);
    }


    @Test
    public void testInstantiation2() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Star starBean = applicationContext.getBean("starBean", Star.class);
        System.out.println(starBean);


    }
}
