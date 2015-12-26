package com.lizhi.quartzjob;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhi1 on 14-8-20.
 */
public class QuartzJobTest {
    public static void main(String[] args){
        System.out.println("Test start");
        ApplicationContext app=new ClassPathXmlApplicationContext("spring-config.xml");
        app.getBean("startQuertz");
        System.out.println("Test end");
    }
}

