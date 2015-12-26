package com.lizhi.jsonutil;

import com.lizhi.JsonUtil;
import com.jd.helloworld.domain.example.Example;
import junit.framework.TestCase;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhi1 on 14-8-18.
 */
public class JsonUtilTest{
    private static ApplicationContext appContext;
    private static  JsonUtil jsonUtil;
    @BeforeClass
    public static void setUp(){
        appContext=new ClassPathXmlApplicationContext("spring-config.xml");
        jsonUtil=(JsonUtil)appContext.getBean("jsonUtil");

    }

    @Test
    public void testObjectToJson() throws Exception {
        Example example =new Example(1,"testjson");
        System.out.println(jsonUtil.objectToJson(example));
    }

    @Test
    public void testJsonToObject() throws Exception {
        String jsonObject="{\"created\":null,\"id\":1,\"modified\":null,\"name\":\"test\",\"type\":1}";
        Example example=(Example) jsonUtil.jsonToObject(jsonObject,Example.class);
        System.out.println("example的Id是："+example.getId());
        System.out.println("名字是："+example.getName());
        System.out.println("类型是："+example.getType());

    }
}
