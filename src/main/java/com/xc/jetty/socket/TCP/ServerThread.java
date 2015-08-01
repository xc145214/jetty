package com.xc.jetty.socket.TCP;

import sun.org.mozilla.javascript.internal.EcmaError;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Administrator on 2015/7/29.
 */
public class ServerThread implements Runnable {

    private Socket client = null;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            //获取socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());

            //h获取socket的输入流吗用来接受客户端发送的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                //接受客户端发送过来的数据
                String str = buf.readLine();
                System.out.println(str);
                if (str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        //将接受的数据加上echo
                        out.println("echo: " + str);
                    }
                }
            }
            out.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
