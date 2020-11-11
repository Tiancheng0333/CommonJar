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
        System.out.println("===============");
        //330206197609135632
        //13062527068
        String pspId="330206197609135632";
        String tel="13062527068";
        String card="ghhh12345";
        System.out.println(pspId.substring(0,pspId.length()-4 ) + "****");
        String encodeTel=tel.substring(0,3)+"****"+tel.substring(7);
        System.out.println(encodeTel);
    }
}
