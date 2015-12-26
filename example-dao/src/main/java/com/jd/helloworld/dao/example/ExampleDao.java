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
     * �г����в�
     * @return
     */
    public List<Example> findExamples() ;

    /**
     * ȡ���ܼ�¼��
     * @return ��¼����
     */
    int getExamplesCount();

    /**
     * ȡ���ܼ�¼��
     * @return ��¼����
     */
    int getExamplesCount(Query query);

    int getExamplesCount1(TimeQuery query);

    /**
     * ȡ����صļ�¼��
     * @param query ��ѯ����
     * @return ��ؼ�¼
     */
    List<Example> findExamplesPage(Query query);

    List<Example>findExamplesPage1(TimeQuery query);

    /**
     * ��������
     * @param example
     */
    void createExample(Example example);

    List<Example> findExamplesByTime(String startDate,String endDate);


    List<Example> findExamplesByTime1(TimeQuery query);
}
