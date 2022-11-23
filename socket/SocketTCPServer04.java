package com.tian.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer04 {
    public static void main(String[] args) throws Exception {
        //服务器端9999端口监听，接收到图片，回复收到再退出
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听");
        //等待连接
        Socket socket = serverSocket.accept();
        //读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到的数组，写入到指定路径
        String destFilePath = "src\\a.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();
        //向客户端回复收到图片
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();
        socket.shutdownOutput();
        //关闭流
        bw.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
