package com.lizhi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by lizhi1 on 14-8-18.
 */
public class JsonUtil {
    private JSONObject JsonObject;

    public String objectToJson(Object o){
        return JsonObject.fromObject(o).toString();
    }

    public Object jsonToObject(String jsonString, Class clazz){
        JSONObject jsonObject=JsonObject.fromObject(jsonString);
        return JsonObject.toBean(jsonObject,clazz);
    }

    /**
     * ��һ��JSON �����ַ���ʽ�еõ�һ��java�������磺
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...}}
     * @param jsonString
     * @param clazz
     * @return
     */
    public  Object getDTO(String jsonString, Class clazz){
        JSONObject jsonObject = null;
        try{
            jsonObject = JSONObject.fromObject(jsonString);
        }catch(Exception e){
            e.printStackTrace();

        }
        return JSONObject.toBean(jsonObject, clazz);
    }

    /**
     * ��һ��JSON �����ַ���ʽ�еõ�һ��java��������beansList��һ��ļ��ϣ����磺
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...},
     * beansList:[{}, {}, ...]}
     * @param jsonString
     * @param clazz
     * @param map �������Ե����� (key : ����������, value : ������������class) eg: ("beansList" : Bean.class)
     * @return
     */
    public  Object getDTO(String jsonString, Class clazz, Map map){
        JSONObject jsonObject = null;
        try{
            jsonObject = JSONObject.fromObject(jsonString);
        }catch(Exception e){
            e.printStackTrace();
        }
        return JSONObject.toBean(jsonObject, clazz, map);
    }

    /**
     * ��һ��JSON����õ�һ��java�������飬���磺
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]
     * @param jsonString
     * @param clazz
     * @return
     */
    public static Object[] getDTOArray(String jsonString, Class clazz){
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for(int i = 0; i < array.size(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }
        return obj;
    }

    public static Object[] getDTOArray(String jsonString, Class clazz, Map map){
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for(int i = 0; i < array.size(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz, map);
        }
        return obj;
    }




    public JSONObject getJsonObject() {
        return JsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        JsonObject = jsonObject;
    }
}
