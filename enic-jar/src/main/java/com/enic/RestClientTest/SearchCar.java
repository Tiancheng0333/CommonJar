package com.enic.RestClientTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class SearchCar {

    static final String url="https://www.dcdapp.com/motor/searchapi/search_content/?keyword=大众&offset=0&count=10&cur_tab=1&city_name=南京&motor_source=pc&format=json";

    public static void main(String[] args) throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet get=new HttpGet(url);
        CloseableHttpResponse execute = defaultHttpClient.execute(get);
        HttpEntity entity = execute.getEntity();
        System.out.println(entity);
        System.out.println(execute);
    }
}
