package com.lizhi;

import java.util.Date;

/**
 * Created by lizhi1 on 14-8-20.
 */
public class QuartzJob {
    public void work()
    {
        System.out.println("Quartz的任务调度！！！");
        System.out.println("开始执行业务-------现在的时间是："+new Date());
    }

}
