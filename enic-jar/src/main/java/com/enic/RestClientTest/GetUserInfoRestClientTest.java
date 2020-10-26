package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;
import com.tuniu.operation.platform.base.rest.RestClient;
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
        RestClient restClient=new RestClient("mob-dist.api.tuniu.org/dist/user/getUserInfoByPValue",encode);
        System.out.println(restClient.execute());
    }
}
