package com.enic.Concurrent;

public class FinalTest {
    private int a;
    private final int b ;
    private static boolean flag=false;
    private FinalTest finalTest;

    public FinalTest() {
        b = 2;
        a=1;
    }

    public static FinalTest write(){
        FinalTest finalTest=new FinalTest();
        return finalTest;
    }

    public static void reder(FinalTest finalTest){
        int a = finalTest.a;
        int b = finalTest.b;
        if(a==0){
            System.out.println(a+":"+b);
        }
    }
    public static void main(String[] args) {

/*         new Thread(() -> {
            while (!flag){
                reder(write());
            }
        }).start();*/
        for (int i = 0; i < 3; i++) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   threadLoop();
               }
           }) .start();
        }
    }

    static void threadLoop(){
        for (int i = 0; i < 5; i++) {
            System.out.println("当前线程{}"+Thread.currentThread().getName());
        }
    }
}
