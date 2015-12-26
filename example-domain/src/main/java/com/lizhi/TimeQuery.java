package com.lizhi;


import com.jd.common.util.base.BaseQuery;

/**
 * Created by lizhi1 on 14-8-8.
 */
public class TimeQuery extends BaseQuery {

    private String dateStart;

    private String dateEnd;

    public void setDateStart(String dateStart){
        this.dateStart=dateStart;
    }

    public String getDateStart(){
        return dateStart;
    }

    public void setDateEnd(String dateEnd){
        this.dateEnd=dateEnd;
    }

    public String getDateEnd(){
        return dateEnd;
    }



}
