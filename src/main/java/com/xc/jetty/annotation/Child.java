package com.xc.jetty.annotation;

/**
 * Created by Administrator on 2015/7/22.
 */
@Description(desc = "this is a class annotation", author = "xc", version = 1)
public class Child implements Person {
    @Override
    public String name() {
        return null;
    }

    public int age() {
        return 0;
    }

    public void sing() {

    }

    @Description(desc = "this is a method annotation", author = "xc", version = 1)
    public String eyeColor() {
        return "red";
    }
}
