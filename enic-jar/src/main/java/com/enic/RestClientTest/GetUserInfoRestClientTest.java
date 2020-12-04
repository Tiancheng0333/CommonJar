package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetUserInfoRestClientTest {
    public static void main(String[] args) throws IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("pValue","67722");
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(JSONObject.toJSON(map).toString().getBytes());
        System.out.println(encode);
        System.out.println("============");
        System.out.println("viewTemplateForTaike".toUpperCase());
        String s="110101199010282338";
        System.out.println(s.substring(10, 12));
        System.out.println(s.substring(12, 14));
        System.out.println("========");
        //RestClient restClient=new RestClient("http://public-api.tof.tuniu.org/tof/manage/sign/html/tmpl?eyJ1aWQiOiIzMTU5MSIsInRva2VuIjpudWxsLCJuaWNrbmFtZSI6IueOi+aIkDEwIiwiciI6MC40NTk0MTQ2ODc3NzQxNjM4Mywib3JkZXJJZCI6MTIzMDA0Nzc5MiwibW9kdWxlT3B0aW9ucyI6eyJjb2xsYXBzZWQiOmZhbHNlfX0=");
        //String execute = restClient.execute();
        //BASE64Decoder decoder=new BASE64Decoder();
        //System.out.println(new String(decoder.decodeBuffer(execute), "utf-8"));
    }
}
