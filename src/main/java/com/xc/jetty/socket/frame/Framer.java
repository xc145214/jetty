package com.xc.jetty.socket.frame;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2015/8/1.
 */
public interface Framer {
    void frameMsg(byte[] message,OutputStream out) throws IOException;
    byte[] nextMsg() throws IOException;
}
