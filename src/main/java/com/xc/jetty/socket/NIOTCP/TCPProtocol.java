package com.xc.jetty.socket.NIOTCP;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by Administrator on 2015/8/1.
 */
public interface TCPProtocol {
    //accept I/O形式
    void handleAccept(SelectionKey key) throws IOException;
    //read I/O形式
    void handleRead(SelectionKey key) throws IOException;
    //write I/O形式
    void handleWrite(SelectionKey key) throws IOException;
}
