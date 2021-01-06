package com.enic.SpringTest;

import java.util.HashMap;
import java.util.Map;

public class MainStart {
    public static void main(String[] args) {
        Map<String,Object> param=new HashMap<>();
        param.put("key1","value1");
        param.put("key2","value2");
        param.put("key3","value3");
        String paramDecode="";
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            paramDecode+=entry.getKey()+"="+entry.getValue()+"&";
        }
        String params = paramDecode.substring(0, paramDecode.length() - 1);
        System.out.println(params);

    }
}
