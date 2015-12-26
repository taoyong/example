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
     * �г����в�
     *
     * @return
     */
    List<Example> findExamples();

    /**
     * ȡ���ܼ�¼��
     *
     * @return ��¼����
     */
    int getExamplesCount();

    int getExamplesCount1(TimeQuery query);

    /**
     * ȡ����صļ�¼��
     *
     * @param query ��ѯ����
     * @return ��ؼ�¼
     */
    List<Example> findExamplesPage(Query query);

    /**
     * ͨ����ҳ����
     *
     * @param example
     *@param pageIndex
     * @param pageSize   @return
     */
    PaginatedList<Example> findExamples(String example, int pageIndex, int pageSize);


       /**
     * ��������
     * @param example
     */
    int createExample(Example example);

    List<Example> findExamplesByTime(String dateStart,String dateEnd);

    PaginatedList<Example> findExamplesByTime1(String dateStart,String dateEnd, int pageIndex, int pageSize);
}
