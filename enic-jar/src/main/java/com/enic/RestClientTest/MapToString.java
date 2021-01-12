package com.enic.RestClientTest;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class MapToString {

    public static void main(String[] args) {
        String data= "{\"isDiy\":false,\"oasiaHotel\":[{\"addTime\":1609896334000,\"addUid\":39,\"buyNum\":1,\"delFlag\":0,\"departDate\":1611331200000,\"endDate\":1611504000000,\"groupType\":3,\"hasFalse\":false,\"hasWaiting\":false,\"id\":513512774,\"interactiveWithStm\":true,\"journeyId\":66422030,\"nonClusterFlag\":false,\"onlineChangeFlag\":false,\"orderId\":1232717925,\"parentResId\":2057460052,\"price\":700.0,\"resourceId\":2057460053,\"resourceMainId\":513512774,\"resourceName\":\"【单房差】<跟团资源测试test勿动gao2020游>测试test勿动gao2020\",\"shouldDoPlugin\":true,\"status\":0,\"updateTime\":1609896334000,\"updateUid\":39}],\"" +
                "isJDOrder\":false,\"isJDLock\":false}";
        System.out.println(new Date("2020-08-11"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse("2020-08-11");
            System.out.println(parse.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date("2020-08-11");
        System.out.println(JSONObject.toJSON(data));
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
