package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tuniu.operation.platform.base.rest.RestClient;
import com.tuniu.operation.platform.base.rest.RestException;
import sun.misc.BASE64Encoder;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RestClientTest {
    public static void main(String[] args) throws RestException {

        Map<String,Object> map=new HashMap<>();
        map.put("appId","86");
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(JSONObject.toJSON(map).toString().getBytes());
        System.out.println(encode);
        RestClient restClient=new RestClient("http://admin.tuniu.org/api/rbzV3/app/filter",encode);
        System.out.println("===================execute执行结果============");
        String execute = restClient.execute();
        System.out.println(JSONObject.parseObject(execute));
        System.out.println("===================execute执行结果============");
        JSONObject jsonObject = JSONObject.parseObject(execute);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray items = (JSONArray) data.get("items");
        //System.out.println(items.get(0));
        JSONObject object = (JSONObject) items.get(0);
        System.out.println(object.get("id"));
        Integer id = (Integer) object.get("id");
        System.out.println(id);
        String birthdayDate="2020-09-08";
        Integer personYear = Integer.parseInt(birthdayDate.substring(0, 4));
        Integer personMonth = Integer.parseInt(birthdayDate.substring(6, 7));
        Integer personDay = Integer.parseInt(birthdayDate.substring(9));
        System.out.println(personYear);
        System.out.println(personMonth);
        System.out.println(personDay);
        Calendar cal = Calendar.getInstance();
        // 得到当前时间的年、月、日
        Integer yearNow = cal.get(Calendar.YEAR);
        Integer monthNow = cal.get(Calendar.MONTH) + 1;
        Integer dayNow = cal.get(Calendar.DATE);
        System.out.println(yearNow);
        System.out.println(monthNow);
        System.out.println(dayNow);
    }
}
