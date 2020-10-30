package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;
import com.tuniu.operation.platform.base.rest.RestException;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

public class GetUserInfoRestClientTest {
    public static void main(String[] args) throws RestException {
        Map<String,Object> map=new HashMap<>();
        map.put("pValue","67722");
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(JSONObject.toJSON(map).toString().getBytes());
        System.out.println(encode);
        System.out.println("============");
        System.out.println("queryJibaoInfo".toUpperCase());
        String s="110101199010282338";
        System.out.println(s.substring(10, 12));
        System.out.println(s.substring(12, 14));
    }
}
