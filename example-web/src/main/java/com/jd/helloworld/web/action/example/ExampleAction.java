/*
 * $Id: HelloWorld.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jd.helloworld.web.action.example;

import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.service.example.ExampleService;
import com.lizhi.ExampleServer;


/**
 * <code>Set welcome message.</code>
 */
public class ExampleAction extends BaseAction {
    
    private ExampleService exampleService;
    private Example example;
    private ExampleServer exampleServer;
    private int pageSize = 5;

    private String startTime;
    private String endTime;

    public String list() throws Exception {
        message = Integer.toString(hashCode());
        /*if(!exampleServer.exists("increament")){
            exampleServer.put("increament","0");
            exampleServer.expire("increament",60);//设定的过时时间单位为秒

        }
        //exampleServer.put(message,"visit");
        exampleServer.incr("increament");
        int count=Integer.parseInt(exampleServer.get("increament"));

        System.out.println("第"+count+"个用户访问");
*/

        String name = null;
        if (example!=null) {
            name = example.getName();
        }
      Result examples = exampleService.findExamples(name, page, pageSize);
        //Result examples = exampleService.findExamples();
        toVm(examples);


        return SUCCESS;
    }

    public String listbytime() throws Exception {


        //Result examples = exampleService.findExamplesByTime(startTime,endTime);
        Result examples = exampleService.findExamplesByTime1(startTime,endTime,page,pageSize);
        toVm(examples);
        return SUCCESS;
    }

    public String add() throws Exception {
        setCookie("a1","abc");
        //setCookie("a2","abc");
        return SUCCESS;
    }


    public String doAdd() throws Exception {
        Result result = exampleService.createExample(example);
        toVm(result);
        return SUCCESS;
    }

    /**
     * Field for Message property.
     */
    private String message;


    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public ExampleService getExampleService() {
        return exampleService;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setStartTime(String startTime){this.startTime=startTime;}
    public String getStartTime(){return startTime;}

    public void setEndTime(String endTime){this.endTime=endTime;}
    public String getEndTime(){return endTime;}

    public void setExampleServer(ExampleServer exampleServer){this.exampleServer=exampleServer;}
}
