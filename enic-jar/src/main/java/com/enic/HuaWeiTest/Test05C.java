package com.enic.HuaWeiTest;

import java.io.IOException;
import java.util.Scanner;

public class Test05C {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = Integer.parseInt(sc.nextLine());
            if (input == 0) {
                return;
            }
            int bottoms = 0;
            while (input >= 3) {
                bottoms += input / 3;
                input = input / 3 + input % 3;
            }
            if(input==2){
                bottoms++;
            }
            System.out.println(bottoms);
        }
    }

}
