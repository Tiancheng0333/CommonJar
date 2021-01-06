package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetUserInfoRestClientTest {
    public static void main(String[] args) throws IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("pValue","67722");
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(JSONObject.toJSON(map).toString().getBytes());
        System.out.println(encode);
        System.out.println("============");
        System.out.println("priceDetailForTaike".toUpperCase());
        String s="110101199010282338";
        System.out.println(s.substring(10, 12));
        System.out.println(s.substring(12, 14));
        System.out.println("========");
        //RestClient restClient=new RestClient("http://public-api.tof.tuniu.org/tof/manage/sign/html/tmpl?eyJ1aWQiOiIzMTU5MSIsInRva2VuIjpudWxsLCJuaWNrbmFtZSI6IueOi+aIkDEwIiwiciI6MC40NTk0MTQ2ODc3NzQxNjM4Mywib3JkZXJJZCI6MTIzMDA0Nzc5MiwibW9kdWxlT3B0aW9ucyI6eyJjb2xsYXBzZWQiOmZhbHNlfX0=");
        //String execute = restClient.execute();
        //BASE64Decoder decoder=new BASE64Decoder();
        //System.out.println(new String(decoder.decodeBuffer(execute), "utf-8"));
    }

    /**
     *
     * Map转String
     * @param map
     * @return
     */
    public static String getMapToString(Map<String,Object> map){
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if(i != keyArray.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
