package com.enic.BatEasy;

import java.util.concurrent.locks.LockSupport;

public class Ri {

    private static final String[] charArr = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static final int[] numArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26};

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (String s : charArr) {
                    System.out.println(s);
                    LockSupport.park();
                }
            }
        });
    }
}
