package com.xc.jetty.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2015/7/22.
 * 定义注解
 */
//元注解
@Target({ElementType.METHOD, ElementType.TYPE})//方法或者类型
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Inherited//允许子类继承
@Documented//生成doc包括信息
public @interface Description {
    String desc();

    String author();

    int version() default 1;
}
