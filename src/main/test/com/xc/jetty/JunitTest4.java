package com.xc.jetty;

import org.junit.Test;

/**
 * Created by Administrator on 2015/7/19.
 * timeout test
 */
public class JunitTest4 {

    @Test(timeout=1000)
    public void infinity(){
        while (true);
    }
}
