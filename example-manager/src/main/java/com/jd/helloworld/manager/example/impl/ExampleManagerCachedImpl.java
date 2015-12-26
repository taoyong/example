package com.jd.helloworld.manager.example.impl;

import com.jd.common.cached.CacheUtils;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;

import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.manager.example.ExampleManager;
import com.lizhi.TimeQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-5-10
 * Time: 13:43:48
 */
public class ExampleManagerCachedImpl implements ExampleManager  {
    private CacheUtils cacheUtils;

    private ExampleManager exampleManager;
    private final static Log log = LogFactory.getLog(ExampleManagerCachedImpl.class);

    public List<Example> findExamples() {
        return exampleManager.findExamples();
    }

    public int getExamplesCount() {
        return exampleManager.getExamplesCount();
    }

    public int getExamplesCount1(TimeQuery query) {
        return exampleManager.getExamplesCount1(query);
    }

    public List<Example> findExamplesPage(Query query) {
        return exampleManager.findExamplesPage(query);
    }

    public PaginatedList<Example> findExamples(String example, int pageIndex, int pageSize) {

        String key = "Popadmin_Exampe_Query_" + example+"_"+pageIndex+"_"+pageSize;
        PaginatedList<Example> o = (PaginatedList<Example>) cacheUtils.get(key);
        if (o == null) {
            o = exampleManager.findExamples(example, pageIndex, pageSize);
            cacheUtils.add(key, 60 * 60 * 24, o);
        }
        return o;
    }?

    public PaginatedList<Example> findExamplesByTime1(String dateStart, String dateEnd, int pageIndex, int pageSize) {
        String key = "Popadmin_Exampe_Query_" + dateStart+"_"+dateEnd+"_"+pageIndex+"_"+pageSize;
        PaginatedList<Example> o = (PaginatedList<Example>) cacheUtils.get(key);
        if (o == null) {
            o = exampleManager.findExamplesByTime1(dateStart,dateEnd, pageIndex, pageSize);
            cacheUtils.add(key, 60 * 60 * 24, o);
        }
        return o;
    }

    public int createExample(Example example) {
        return exampleManager.createExample(example);
    }

    public List<Example> findExamplesByTime(String dateStart,String dateEnd){
        return exampleManager.findExamplesByTime(dateStart, dateEnd);
    }

    public void setExampleManager(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }


    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }
}
