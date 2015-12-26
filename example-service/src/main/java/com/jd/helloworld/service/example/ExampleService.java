package com.jd.helloworld.service.example;

import com.jd.common.web.result.Result;
import com.jd.helloworld.domain.example.Example;
 

/**
 * User: yangsiyong@360buy.com
 * Date: 2010-4-16
 * Time: 11:37:51
 */
public interface ExampleService {

      /**
     * �г����в�
     * @return
     */
    Result findExamples() ;

    /**
     * ͨ����ҳ����
     * @param name
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result findExamples(String name, int pageIndex, int pageSize) ;


       /**
     * ��������
     * @param example
     */
    Result createExample(Example example);

    Result findExamplesByTime(String dateStart,String dateEnd);

    Result findExamplesByTime1(String dateStart,String dateEnd,int pageIndex, int pageSize) ;
}
