package com.enic.HuaWeiTest;
import java.util.Scanner;

public class Test05 {

    private int cal(int number) {
        int bottoms = 0;
        while (number >= 3) {
            bottoms += number/3;
            number = number%3 + number/3;
        }
        if (number == 2) {
            bottoms++;
        }
        return bottoms;
    }
    public Test05() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            if (number == 0) break;
            int result = cal(number);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Test05 solution = new Test05();
    }
}