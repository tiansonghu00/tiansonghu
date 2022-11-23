package com.tian.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient01 {
    public static void main(String[] args) throws IOException {
        //客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端" + socket.getClass());
        //连接上后，生成socket，通过socket.getOutputStream(),得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        outputStream.write("hello".getBytes());
        //关闭流对象和socket
        outputStream.close();
        socket.close();
    }
}
