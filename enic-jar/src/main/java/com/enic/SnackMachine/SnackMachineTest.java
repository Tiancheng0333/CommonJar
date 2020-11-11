package com.enic.SnackMachine;

import java.util.Scanner;

public class SnackMachineTest {
    public static void main(String[] args) {
        SnackMachine snackMachine = new SnackMachine(20, 2);
        PackOfCrisps packOfCrisps = new PackOfCrisps("番茄口味");
        PackOfCrisps packOfCrisps1 = new PackOfCrisps("苹果口味");
        PackOfCrisps packOfCrisps2 = new PackOfCrisps("香蕉口味");
        PackOfCrisps packOfCrisps3 = new PackOfCrisps("黄瓜口味");
        snackMachine.addPack(packOfCrisps);
        snackMachine.addPack(packOfCrisps1);
        snackMachine.addPack(packOfCrisps2);
        snackMachine.addPack(packOfCrisps3);
        Scanner sc = new Scanner(System.in);
        String isCon = "";
        do {
            System.out.println("欢迎来到快乐自动售卖机～");
            String input = sc.nextLine();
            if (input.equals("insert")) {
                snackMachine.insertMoney(new Penny());
                continue;
            }
            PackOfCrisps packOfCrisps4 = snackMachine.buyPack(input);
            System.out.println(packOfCrisps4);
            System.out.println("is Con Y/N?");
            isCon = sc.nextLine();
        } while (!isCon.equals("N") || !isCon.equals("n"));

    }
}
