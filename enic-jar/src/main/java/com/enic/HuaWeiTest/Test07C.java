package com.enic.HuaWeiTest;

import java.util.Scanner;

public class Test07C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] input = sc.nextLine().split(" ");
            int m=Integer.parseInt(input[0]);
            int n=Integer.parseInt(input[1]);
            if(m<n){
                int temp=n;
                n=m;
                m=temp;
            }
            int j=m*n;
            while (n!=0){
               int r= m%n;
               m=n;
               n=r;
            }
            int max=j/m;
            System.out.println(max);
        }
    }
}
