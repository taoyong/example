package com.jd.helloworld.manager.example.impl;

import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import com.jd.helloworld.dao.example.ExampleDao;
import com.jd.helloworld.domain.example.Example;
import com.jd.helloworld.manager.example.ExampleManager;
import com.lizhi.TimeQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.JVMRandom;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

//import com.lizhi.TimeQuery;

/**
 * User: Administrator
 * Date: 2010-4-19
 * Time: 14:03:37
 */
public class ExampleManagerImpl extends BaseManager implements ExampleManager {
     private final static Log log = LogFactory.getLog(ExampleManagerImpl.class);
    private ExampleDao exampleDao;

    public List<Example> findExamples() {
        return exampleDao.findExamples();
    }


    public int getExamplesCount() {
        return exampleDao.getExamplesCount();
    }

    public int getExamplesCount1(TimeQuery query) {
        return exampleDao.getExamplesCount1(query);
    }

    public List<Example> findExamplesPage(Query query) {
        return exampleDao.findExamplesPage(query);
    }

    public PaginatedList<Example> findExamples(String name,int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        if(StringUtils.isNotBlank(name)) { //���ò�ѯ����
            baseQuery.setValue("%"+name+"%"); //һ������²���ʹ��like
        }

        int totalItem = exampleDao.getExamplesCount(baseQuery); //�õ��ܵļ�¼����

        PaginatedList<Example> examples = new PaginatedArrayList<Example>(pageIndex, pageSize); //���췵�ض�����Ҫ������ҳ������ʾ
        examples.setTotalItem(totalItem);//�����ܼ�¼��

        baseQuery.setStartRow(getMySqlStartRow(examples.getStartRow()));//�������ݿ����ʼλ��
        //baseQuery.setEndRow(examples.getEndRow());//�������ݿ�Ľ���λ��
        baseQuery.setEndRow(examples.getPageSize());

        List<Example> exampleList = exampleDao.findExamplesPage(baseQuery);//��ѯ�õ���Ӧ�ļ�¼

        examples.addAll(exampleList);
        return examples;
    }
    /**
     * ȡmysql��ҳʱ����ʼ��,mysql��0��ʼ
     *
     * @param startRow
     * @return
     */
    protected int getMySqlStartRow(int startRow) {
        return startRow > 1 ? startRow - 1 : 0;
    }


    public int createExample(final Example example) {
       // example.setId((int) sequenceUtil.get("pop_user_example_id"));
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    exampleDao.createExample(example);
                   /* int rnd = new JVMRandom().nextInt(2);
                    if (rnd == 1) {
                        throw new Exception("�������");
                    }*/
                } catch (Exception e) {
                    log.error("createExample error!",e);
                     status.setRollbackOnly();
                    throw new RuntimeException("gaga",e);
                }
            }
        });
        return example.getId();
    }

    public void setExampleDao(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }

    public List<Example> findExamplesByTime(String dateStart,String dateEnd){
        return exampleDao.findExamplesByTime(dateStart, dateEnd);
    }

    public PaginatedList<Example> findExamplesByTime1(String dateStart, String dateEnd, int pageIndex, int pageSize) {
        TimeQuery baseQuery = new TimeQuery();
        if(StringUtils.isNotBlank(dateStart)) { //���ò�ѯ����
            baseQuery.setDateStart(dateStart); //һ������²���ʹ��like
        }
        if(StringUtils.isNotBlank(dateEnd)) { //���ò�ѯ����
            baseQuery.setDateEnd(dateEnd); //һ������²���ʹ��like
        }

        int totalItem = exampleDao.getExamplesCount1(baseQuery); //�õ��ܵļ�¼����

        PaginatedList<Example> examples = new PaginatedArrayList<Example>(pageIndex, pageSize); //���췵�ض�����Ҫ������ҳ������ʾ
        examples.setTotalItem(totalItem);//�����ܼ�¼��

        baseQuery.setStartRow(getMySqlStartRow(examples.getStartRow()));//�������ݿ����ʼλ��
        //baseQuery.setEndRow(examples.getEndRow());//�������ݿ�Ľ���λ��
        baseQuery.setEndRow(examples.getPageSize());

        List<Example> exampleList = exampleDao.findExamplesPage1(baseQuery);//��ѯ�õ���Ӧ�ļ�¼

        examples.addAll(exampleList);
        return examples;
    }
}
