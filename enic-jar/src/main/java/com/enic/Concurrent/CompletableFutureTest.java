package com.enic.Concurrent;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    @Test
    public void thenCombine() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }

    @Test
    public void thenAcceptBoth() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(byteArrayOutputStream);
        PrintStream printStream1=System.out;
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> {
            System.setOut(printStream);
            System.out.println(s1 + " " + s2);
        });
        while (byteArrayOutputStream.toString().length()<13){
            if(byteArrayOutputStream.toString().length()>11){
                System.setOut(printStream1);
                System.out.println(byteArrayOutputStream.toString()+"here");
                break;
            }
        }
    }

    @Test
    public void systemOut(){
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        // cache stream
        PrintStream cacheStream = new PrintStream(baoStream);
        // old stream
        PrintStream oldStream = System.out;

        System.setOut(cacheStream);

        System.out.print("hello world!");

        String message = baoStream.toString();

        message = "<-- " + message + " -->";

        // Restore old stream
        System.setOut(oldStream);

        System.out.println(message);
    }
}
