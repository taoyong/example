package com.lizhi.redistest;
import com.jd.helloworld.domain.example.Example;
import com.lizhi.ExampleServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhi1 on 14-8-14.
 */
public class JedisTemplateTest {
    public static void main(String[] args){
         ApplicationContext app=new ClassPathXmlApplicationContext("spring-config.xml");
        //RedisTemplate redisTemplate = (RedisTemplate) app.getBean("redisTemplate");
        ExampleServer exampleServer=(ExampleServer) app.getBean("exampleServer");
        Example example=new Example(1,"testExample");

        System.out.println("==== getting objects from redis ====");
        System.out.println("Example is not in redis "+exampleServer.get(example));
        System.out.println("==== put objects to redis ====");
        exampleServer.put(example);
        System.out.println("example is in redis ");
        System.out.println("==== getting objects from redis ====");
        System.out.println("Example should be in redis yet: " + exampleServer.get(example));
        System.out.println("==== deleting objects from redis ====");
        exampleServer.del(example);
        System.out.println("==== getting objects from redis ====");
        System.out.println("Example is not in redis yet: " + exampleServer.get(example));

        int temp=0;
        for(int i=0;i<1000;i++){
            if(!exampleServer.exists("increament")){
                exampleServer.put("increament","0");
                exampleServer.expire("increament",60);//设定的过时时间单位为秒

            }
            exampleServer.put(example);
            exampleServer.incr("increament");
            int count=Integer.parseInt(exampleServer.get("increament"));

            if(count<=temp){
                System.out.println("一分钟内有"+temp+"个用户访问");

            }
            temp=count;
        }

    }
}
