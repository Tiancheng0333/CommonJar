package com.enic.Polymorphic;

import org.springframework.stereotype.Service;

import java.util.Random;


@Service("BusinessDefault")
public class Business implements IBusiness {
    @Override
    public Integer calForAvg() {
        System.out.println(new Random(10).nextInt());
        System.out.println(Thread.currentThread().getName());
        return new Random(10).nextInt();
    }

    @Override
    public String getMaxAge() {
        return "getMaxAge";
    }

    @Override
    public SupportedEnum support(Object... prams) {
        return SupportedEnum.DEFAULT_CAL;
    }
}
