package com.enic.JavaSeDemo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

@Data
@RestController
public class SetAnnotationValueByReflect {


    final static Integer POSTER_APPID=11113;

    final static Integer POP_APPID=1111;

    private Integer appId;

    @AnnotationOfA(money = 2500)
    public static void ModifyAnnotationValue(){
        try {
            Method modifyAnnotationValue = SetAnnotationValueByReflect.class.getDeclaredMethod("ModifyAnnotationValue", null);
            //判断此注解是否在目标方法上
            boolean annotationPresent = modifyAnnotationValue.isAnnotationPresent(AnnotationOfA.class);
            if(annotationPresent){
                AnnotationOfA annotation = modifyAnnotationValue.getAnnotation(AnnotationOfA.class);
                double money = annotation.money();
                System.out.println("未反射修改前数值:["+money+"]");
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
                Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
                memberValues.setAccessible(true);
                Map map = (Map) memberValues.get(invocationHandler);
                for (Object o : map.entrySet()) {
                    System.out.println("此时此注解属性在代理里的值:"+o);
                }
                map.put("money",2000.0);
                for (Object o : map.entrySet()) {
                    System.out.println("修改后此注解属性在代理里的值:"+o);
                }
                System.out.println("修改后此注解属性里的值"+annotation.money());
            }
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    //动态设置属性值
    private static Integer dynamicSetProperty(Integer posterType) throws NoSuchFieldException, IllegalAccessException {
        SetAnnotationValueByReflect setAnnotationValueByReflect=new SetAnnotationValueByReflect();

        Field appId = setAnnotationValueByReflect.getClass().getDeclaredField("appId");
        appId.setAccessible(true);
        if(posterType.equals(0)){
            appId.set(setAnnotationValueByReflect,POSTER_APPID);
        }else {
            appId.set("appId",POP_APPID);
        }
        System.out.println(setAnnotationValueByReflect.getAppId());
        return setAnnotationValueByReflect.getAppId();
    }

    @RequestMapping("/go")
    public String get() throws NoSuchFieldException, IllegalAccessException {
        dynamicSetProperty(0);
        System.out.println(appId);
        return appId+"";
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        dynamicSetProperty(0);

        //ModifyAnnotationValue();
    }
}

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationOfA{
    double money() default 1000;
}

