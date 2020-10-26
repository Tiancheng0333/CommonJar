package com.enic.EasyPrivateWork;

public class PickDemo {
    public static void main(String[] args) {
        int tmp=countZerosInFactorial(100000);
        System.out.println(tmp);
    }

    public static int countZerosInFactorial(int n){
        if(n<5){
            return -1;
        }
        int count=0;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
