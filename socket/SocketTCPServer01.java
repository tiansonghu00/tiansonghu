package com.tian.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer01 {
    public static void main(String[] args) throws IOException {
        //在本机的9999端口监听，等待链接，
        //要求在本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接");
        //没有客户端链接时，程序会阻塞，等待连接,如果有，就会返回socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端" + socket.getClass());
        //通过socket.getInputStream()获取客户端写入到数据通道的数据，并显示
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,readLen));
        }
        //关闭
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
