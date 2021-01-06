package com.enic.SpringMvcTest;

import com.enic.JvmTest.MyClassLoader001;

public class Test {
    @AutoWiredMvc("MyClassLoader001")
    private MyClassLoader001 myClassLoader001;

    public static void main(String[] args) {
        new Test().myClassLoader001.sout();
    }
}
