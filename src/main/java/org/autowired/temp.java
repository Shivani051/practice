package org.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class temp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org.autowired.autowiredconfig.xml");

        Emp emp2 = context.getBean("emp2", Emp.class);
        System.out.println(emp2);
//        shivani manav
        System.out.println("hello");
    }
}
