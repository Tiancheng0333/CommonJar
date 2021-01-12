package com.enic.ProxyTest;

public class LiuDeHua implements star {
    @Override
    public String sing() {
        System.out.println("在唱歌");
        return "唱的很好";
    }

    @Override
    public void dance() {
        System.out.println("在跳舞");
    }
}
