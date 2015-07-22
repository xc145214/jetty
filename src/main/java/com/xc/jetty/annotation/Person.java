package com.xc.jetty.annotation;

/**
 * Created by Administrator on 2015/7/22.
 */
public interface Person {
    public String name();

    public int age();

    //表示方法已经过时
    @Deprecated
    public void sing();



}
