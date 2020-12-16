package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;
import com.enic.RestClientTest.vo.OrderHeadVo;
import com.tuniu.operation.platform.base.rest.RestClient;
import com.tuniu.operation.platform.base.rest.RestException;
import sun.misc.BASE64Encoder;

import java.util.Calendar;

public class RestClientTest {

    public static final String RBZ_URL="http://admin.tuniu.org/api/rbzV3/app/filter";
    public static final String TOF_URL="http://public-api.tof.tuniu.org/tof/manage/order/head/query";

    public static void main(String[] args) throws RestException {

        String orderId="1229993947";
        String param="{\"orderId\":"+orderId+"}";
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(JSONObject.toJSON(param).toString().getBytes());
        RestClient restClient=new RestClient(TOF_URL,encode);
        System.out.println("===================execute执行结果============");
        String execute = restClient.execute();
        JSONObject object = JSONObject.parseObject(execute);
        OrderHeadVo orderHeadVo = JSONObject.parseObject(JSONObject.toJSONString(object.get("data")), OrderHeadVo.class);
        System.out.println(orderHeadVo);
        System.out.println("===================execute执行结果============");
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
