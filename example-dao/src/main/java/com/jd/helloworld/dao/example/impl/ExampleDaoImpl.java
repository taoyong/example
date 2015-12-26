package com.jd.helloworld.dao.example.impl;

import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;
import com.jd.helloworld.dao.example.ExampleDao;
import com.jd.helloworld.domain.example.Example;
import com.lizhi.TimeQuery;

import java.util.HashMap;
import java.util.List;

/**
 * User: Administrator
 * Date: 2010-4-15
 * Time: 18:23:46
 */
@SuppressWarnings("unchecked")
public class ExampleDaoImpl extends BaseDao implements ExampleDao {

    public List<Example> findExamples() {        
        return queryForList("Example.findExamples");
    }

    public void createExample(Example example) {
       insert("Example.createExample",example);
    }

    public int getExamplesCount() {
        return (Integer)queryForObject("Example.getExamplesCount");
    }

    public int getExamplesCount(Query query) {
        return (Integer)queryForObject("Example.getExamplesCount",query);
    }

    public int getExamplesCount1(TimeQuery query) {
        return (Integer)queryForObject("Example.getExamplesCount1",query);
    }


    public List<Example> findExamplesPage(Query query) {
        return queryForList("Example.findExamplesPage",query);
    }

    public List<Example> findExamplesPage1(TimeQuery query) {
        return queryForList("Example.findExamplesPage1",query);
    }

    public List<Example> findExamplesByTime(String dateStart,String dateEnd){
        HashMap map=new HashMap();
        map.put("dateStart",dateStart);
        map.put("dateEnd",dateEnd);
        return queryForList("Example.findExamplesByTime",map);
    }

    public List<Example> findExamplesByTime1(TimeQuery query){
        return queryForList("Example.findExamplesByTime1",query);
    }
}
