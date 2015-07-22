package com.xc.jetty;

import com.xc.jetty.annotation.Child;
import com.xc.jetty.annotation.Description;
import com.xc.jetty.annotation.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/7/22.
 */

public class AnnotationTest {

    //忽略过时
    @Test
    @SuppressWarnings("deprecation")
    public void testAnnotation() {
        Person p = new Child();
        p.sing();
    }


    @Test
    public void testAnnotation2() {

        //1.使用类加载器加载类
        try {
            Class c = Class.forName("com.xc.jetty.annotation.Child");
            //2.找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                //3. 获取注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.desc());
            }
            //找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description d = (Description) m.getAnnotation(Description.class);
                    System.out.println(d.desc());
                }
            }

            //换一种解析方法上的注解
            for (Method m : ms) {
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        System.out.println(((Description) a).desc());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
