package com.jd.helloworld.manager.example;

import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;
import com.jd.helloworld.domain.example.Example;
import com.lizhi.TimeQuery;

import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-19
 * Time: 14:03:00
 */
public interface ExampleManager {

    /**
     * 列出所有测
     *
     * @return
     */
    List<Example> findExamples();

    /**
     * 取得总记录数
     *
     * @return 记录数量
     */
    int getExamplesCount();

    int getExamplesCount1(TimeQuery query);

    /**
     * 取得相关的记录数
     *
     * @param query 查询参数
     * @return 相关记录
     */
    List<Example> findExamplesPage(Query query);

    /**
     * 通过分页查找
     *
     * @param example
     *@param pageIndex
     * @param pageSize   @return
     */
    PaginatedList<Example> findExamples(String example, int pageIndex, int pageSize);


       /**
     * 创建对象
     * @param example
     */
    int createExample(Example example);

    List<Example> findExamplesByTime(String dateStart,String dateEnd);

    PaginatedList<Example> findExamplesByTime1(String dateStart,String dateEnd, int pageIndex, int pageSize);
}
