package com.tian.homework20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {
        //接收用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要下载文件名");
        String downloadFileName = scanner.next();
        //客户端连接服务端，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //获取和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        //设置写入结束标志
        socket.shutdownOutput();
        //读取服务端返回的文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //得到一个输出流，将bytes写入到磁盘
        String filePath = "d:\\" + downloadFileName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        //关闭资源
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("下载完毕");
    }
}
