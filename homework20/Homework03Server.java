package com.tian.homework20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //服务器端9999端口监听，接收到图片，回复收到再退出
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听");
        //等待连接
        Socket socket = serverSocket.accept();
        //读取客户端发送的要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(bytes)) != -1) {
            downLoadFileName += new String(bytes,0,len);
        }
        System.out.println("客户端希望下载的文件名=" + downLoadFileName);
        //如果下载的是这个图就返回该文件，不是的话返回一个音乐文件
        String resFileName = "";
        if ("th.jpg".equals(downLoadFileName)) {
            resFileName = "src\\th.jpg";
        } else {
            resFileName = "src\\bgm.wav";
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        //使用工具类
        byte[] bytes1 = StreamUtils.streamToByteArray(bis);
        //得到socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes1);
        socket.shutdownOutput();
        //关闭资源
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
