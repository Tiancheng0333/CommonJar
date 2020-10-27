package com.enic.ListSort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse("2020-10-21", DATE_FORMATTER);
        System.out.println(parse);
        Date date=new Date();
        String format = dateFormat.format(date);
        format+=" 00:00:00";
        System.out.println(format);
        System.out.println("=============");
        System.out.println(date.getTime());
        Date date1=new Date(date.getTime());
        System.out.println(date1);
        long l = date.getTime() - System.currentTimeMillis();
        if(l<0){
            System.out.println(l);
        }
        System.out.println(System.currentTimeMillis());
    }
}
