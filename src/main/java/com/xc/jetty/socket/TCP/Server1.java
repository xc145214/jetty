package com.xc.jetty.socket.TCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2015/7/29.
 *
 * TCP server
 */
public class Server1 {
    public static void main(String[] args) throws Exception {
        //服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server = new ServerSocket(20006);
        Socket client = null;
        boolean f = true;
        while (f) {
            //等待客户端的连接，如果没有获取链接
            client = server.accept();
            System.out.println("于客户端连接成功！");

            //为每个客户端连接开启一个线程
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}
