package com.xc.jetty;

import org.junit.Test;

/**
 * Created by Administrator on 2015/7/19.
 */
public class JunitTest2 {
    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
    }
}
