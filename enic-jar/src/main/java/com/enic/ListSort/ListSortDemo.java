package com.enic.ListSort;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ListSortDemo {


    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("2020-09-25 18:51:56","小王"));
        list.add(new Student("2020-09-25 18:53:11","小红"));
        list.add(new Student("2020-10-27 15:24:16","小白"));
        list.add(new Student("2020-10-27 20:59:13","小蓝"));
        System.out.println(list);
        System.out.println("===========================================");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Date parse=null;
                Date parse1=null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                LocalDateTime parse2 = LocalDateTime.parse(o1.getBirthday(), formatter);
                LocalDateTime parse3 = LocalDateTime.parse(o2.getBirthday(), formatter);
                return -parse2.compareTo(parse3);
            }
        });
        System.out.println("==========lambda=======");
        System.out.println(list.stream().filter(item -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime parse = LocalDateTime.parse(item.getBirthday(), formatter);
            Long milliSecond = parse.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            return milliSecond > System.currentTimeMillis();
        }).collect(Collectors.toList()));
    }
}
