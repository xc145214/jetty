package com.xc.jetty.socket.deadLock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Administrator on 2015/8/1.
 */
public class TCPEchoClient {

    public static void main(String[] args) throws IOException {

        if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String server = args[0];       // Server name or IP address
        // Convert argument String to bytes using the default character encoding
        byte[] data = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        // Create socket that is connected to server on specified port
        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);  // Send the encoded string to the server
        socket.shutdownOutput(); //先关闭网络输出流后关闭套接字

        // Receive the same string back from the server
        int totalBytesRcvd = 0;  // Total bytes received so far
        int bytesRcvd;           // Bytes received in last read

//        while (totalBytesRcvd < data.length) {
//            if ((bytesRcvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1)
//                throw new SocketException("Connection closed prematurely");
//            totalBytesRcvd += bytesRcvd;
//        }  // data array is full


        while((bytesRcvd = in.read())!= -1){
            data[totalBytesRcvd] = (byte)bytesRcvd;
            System.out.println((char)data[totalBytesRcvd]);
            totalBytesRcvd++;
        }
        System.out.println("Received: " + new String(data));

        socket.close();  // Close the socket and its streams
    }
}
