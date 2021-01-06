package com.enic.JvmTest;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 自定义类加载器 打破双亲委派机制
 */
public class MyClassLoader002 extends ClassLoader {
    private String classPath;


    public MyClassLoader002(){

    }

    public MyClassLoader002(String classPath){
        this.classPath=classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fileInputStream = new FileInputStream(classPath + '/' + name + ".java");
        int len = fileInputStream.available();
        byte[] data = new byte[len];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = loadByte(name);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    if(!name.startsWith("com")){
                        c = this.getParent().loadClass(name);
                    }else {
                        c = findClass(name);
                    }
                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    public static void main(String[] args) {
        MyClassLoader002 classLoader002=new MyClassLoader002("/Users/wangcheng10/Downloads");
        try {
            Class<?> clazz = classLoader002.loadClass("com.enic.JvmTest.User");
            Object obj = clazz.newInstance();
            Method sout = clazz.getDeclaredMethod("describe",null);
            sout.invoke(obj,null);
            System.out.println(clazz.getClassLoader().getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
