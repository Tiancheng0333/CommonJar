package com.enic.ListSort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String birthday;
    private String name;

    public static void main(String[] args) {
        Student student=new Student("2020-10-20","橙子");
        finalTest(student);

    }
    public static void finalTest(Student student){
        System.out.println(student);
        student=new Student();
        student.setName("车车");
        System.out.println(student);
    }


}
