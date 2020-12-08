package com.enic.Concurrent;

/**
 * 指令重排：代码执行顺序与预期不一致 (发生在前后行代码无联系时)
 * 目的：提高性能
 *
 */
public class HappenBefore {
    private  volatile static int a=0;
    private volatile static boolean flag=false;
    
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100000;i++) {
            a=0;
            flag=false;
            
            //线程一：更改数据
            Thread t1=new Thread(()->{
                a=1;
                flag=true;
            });
            //线程二：读取数据
            Thread t2=new Thread(()->{
                if(flag){
                    a*=1;
                }
                //指令重排
                if(a==0){
                    System.out.println("happen-before->"+a);
                }
            });
            t1.start();
            t2.start();
            
            t1.join();
            t2.join();
            
        }
    }
}
