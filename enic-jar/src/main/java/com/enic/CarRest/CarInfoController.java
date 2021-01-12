package com.enic.CarRest;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class CarInfoController {

    public static final String url="https://www.dongchedi.com/motor/searchapi/search_content/?keyword=";

    @RequestMapping(value = "/car",method = RequestMethod.GET)
    public Object queryCarInfo(CarParam carParam) throws Exception {
        String urlTest="https://www.dongchedi.com/motor/searchapi/search_content/?keyword=%E5%A5%A5%E8%BF%AAA4l&offset=0&count=10&cur_tab=1&city_name=%E5%8D%97%E4%BA%AC&motor_source=pc&format=json";
        String apiUrl = url + carParam.getKeyWord() + "&offset=0&count=10&cur_tab=1&city_name=南京&motor_source=pc&format=json";
        String get = sendGet(urlTest);
        JSONObject parse = (JSONObject)JSONObject.parse(get);
        JSONArray object = (JSONArray) parse.get("data");
        JSONObject o = (JSONObject)object.get(0);
        JSONObject display = (JSONObject)o.get("display");
        CarResponse res=new CarResponse();
        //===========================display区域==============================
        Object origin = display.get("origin");
        Object agentPrice = display.get("agent_price");
        Object seriesName = display.get("series_name");
        Object seriesType = display.get("series_type");
        res.setOrigin(String.valueOf(origin));
        res.setAgentPrice(String.valueOf(agentPrice));
        res.setSeriesName(String.valueOf(seriesName));
        res.setSeriesType(String.valueOf(seriesType));
        JSONArray carsGroup = (JSONArray) display.get("cars_group");
        JSONObject object1 = (JSONObject) carsGroup.get(0);
        JSONArray item = (JSONArray) object1.get("item");
        List<CarsGroup> list=new ArrayList<>();
        for (Object o1 : item) {
            JSONObject object2 = (JSONObject) o1;
            Object car_name = object2.get("car_name");
            Object price_tag = object2.get("price_tag");
            Object price = object2.get("price");
            CarsGroup carsGroup1=new CarsGroup();
            carsGroup1.setCarName(String.valueOf(car_name));
            carsGroup1.setPrice_tag(String.valueOf(price_tag));
            carsGroup1.setPrice(String.valueOf(price));
            list.add(carsGroup1);
        }
        res.setCarsGroup(list);
        //=======================picInfo开始=============================
        JSONObject picInfo = (JSONObject) o.get("pic_info");
        JSONObject wg = (JSONObject) picInfo.get("wg");
        JSONObject ns = (JSONObject) picInfo.get("ns");
        Object name = wg.get("name");
        Object picUrl = wg.get("cover_pic_url");
        Object name1 = ns.get("name");
        Object nsUrl = ns.get("cover_pic_url");
        res.setWgName(String.valueOf(name));
        res.setWgPicUrl(String.valueOf(picUrl));
        res.setNsName(String.valueOf(name1));
        res.setNsPicUrl(String.valueOf(nsUrl));
        return res.toString();
    }


    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}
