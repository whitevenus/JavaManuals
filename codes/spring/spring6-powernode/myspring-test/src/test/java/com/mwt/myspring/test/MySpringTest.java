package com.mwt.myspring.test;

import com.mwt.myspring.bean.OrderService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {

    @Test
    public void testMySpring() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object vip = applicationContext.getBean("vip");
        System.out.println(vip);

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.generate();

    }
}
