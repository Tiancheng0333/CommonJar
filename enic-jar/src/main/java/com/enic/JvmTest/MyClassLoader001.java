package com.enic.JvmTest;

import java.io.FileInputStream;
import java.lang.reflect.Method;


/**
 * 自定义类加载器 使用父类双亲委派机制（使用父类loadClass方法）
 */
public class MyClassLoader001 extends ClassLoader {
    private String classPath;

    public MyClassLoader001(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fileInputStream = new FileInputStream(classPath + '/' + name + ".class");
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

    public static void main(String args[]) throws Exception {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader001 classLoader = new MyClassLoader001("/Users/wangcheng10/Downloads");
        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("com.enic.JvmTest.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("describe", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
