package com.enic.SpringMvcTest;

import com.enic.JvmTest.MyClassLoader001;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

@ControllerMvc
public class MvcTest {

    @AutoWiredMvc("MyClassLoader001")
    private  MyClassLoader001 myClassLoader001;

    public static void main(String[] args) {
            List<String> iocMap = new ArrayList<>();
            Map<String,Object> ioc=new HashMap<>();
            URL resources = MvcTest.class.getClassLoader().getResource("com/enic/SpringMvcTest");
            URL resources1 = MvcTest.class.getClassLoader().getResource("com/enic/JvmTest");
            toIocMap(resources.getFile(),iocMap);
            toIocMap(resources1.getFile(),iocMap);
            for (String bean : iocMap) {
                try {
                    Class<?> clazz = Class.forName(bean);
                    if(!clazz.isAnnotation()){
                        ioc.put(clazz.getSimpleName(),clazz.newInstance());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Map.Entry<String, Object> entry : ioc.entrySet()) {
                try {
                    Object bean = entry.getValue();
                    Class<?> clazz = bean.getClass();
                    if(clazz.isAnnotationPresent(ControllerMvc.class)){
                        Field[] fields = clazz.getDeclaredFields();
                        for (Field field : fields) {
                            if(field.isAnnotationPresent(AutoWiredMvc.class)){
                                AutoWiredMvc annotation = field.getAnnotation(AutoWiredMvc.class);
                                field.setAccessible(true);
                                field.set(bean,ioc.get(annotation.value()));
                                System.out.println(field);

                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        Scanner sc=new Scanner(System.in);
            sc.nextLine();
    }

    //模仿将全限定名加入Ioc容器
   static void toIocMap(String fileName,List<String> iocMap){
        File file = new File(fileName);
        for (File item : file.listFiles()) {
            if(item.isDirectory()){
                System.out.println("======");
            }else {
                if(fileName.contains("SpringMvcTest")){
                    String packName="com.enic.SpringMvcTest."+item.getName().replaceAll(".class","");
                    System.out.println(packName);
                    iocMap.add(packName);
                }else {
                    String packName="com.enic.JvmTest."+item.getName().replaceAll(".class","");
                    System.out.println(packName);
                    iocMap.add(packName);
                }
            }
        }
    }

}
