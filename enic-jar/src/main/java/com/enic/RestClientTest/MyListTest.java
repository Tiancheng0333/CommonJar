package com.enic.RestClientTest;

public class MyListTest {
    public static void main(String[] args) {
        MyStringList msl = new MyStringList();
        msl.insert("e0");
        msl.insert("e1");
        msl.insert("e1");
        System.out.println("insert Success");
        int e1 = msl.findCount("e1");
        if (e1 == 2) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        msl.delete("e1");
        int e11 = msl.findCount("e1");
        if(e11==1){
            System.out.println("Delete Success");
        }else {
            System.out.println("Delete Fail");
        }
        System.out.println(msl.firstNode());
        System.out.println("FirstNode Success");
        System.out.println(msl.getHead());

    }
}
