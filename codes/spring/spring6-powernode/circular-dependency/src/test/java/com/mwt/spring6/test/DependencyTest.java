package com.mwt.spring6.test;

import com.mwt.spring6.bean.Husband;
import com.mwt.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyTest {



    @Test
    public void testCd() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);

        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);


    }
}
