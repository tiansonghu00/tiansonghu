package com.tian.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient02 {
    public static void main(String[] args) throws IOException {
        //客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端" + socket.getClass());
        //连接上后，生成socket，通过socket.getOutputStream(),得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();
        //获取和socket关联的输入流，读取数据(字节)并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int  readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,readLen));
        }
        //关闭流对象和socket
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
