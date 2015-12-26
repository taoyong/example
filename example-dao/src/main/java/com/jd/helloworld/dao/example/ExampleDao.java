package com.jd.helloworld.dao.example;

import com.jd.common.util.Query;
import com.jd.helloworld.domain.example.Example;
import com.lizhi.TimeQuery;


import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-15
 * Time: 18:17:34
 */
public interface ExampleDao {

    /**
     * 列出所有测
     * @return
     */
    public List<Example> findExamples() ;

    /**
     * 取得总记录数
     * @return 记录数量
     */
    int getExamplesCount();

    /**
     * 取得总记录数
     * @return 记录数量
     */
    int getExamplesCount(Query query);

    int getExamplesCount1(TimeQuery query);

    /**
     * 取得相关的记录数
     * @param query 查询参数
     * @return 相关记录
     */
    List<Example> findExamplesPage(Query query);

    List<Example>findExamplesPage1(TimeQuery query);

    /**
     * 创建对象
     * @param example
     */
    void createExample(Example example);

    List<Example> findExamplesByTime(String startDate,String endDate);


    List<Example> findExamplesByTime1(TimeQuery query);
}
