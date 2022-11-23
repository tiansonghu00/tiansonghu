package com.tian.homework20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    //使用字符流方法
    public static void main(String[] args) throws IOException {
        //在本机的9999端口监听，等待链接，
        //要求在本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接");
        //没有客户端链接时，程序会阻塞，等待连接,如果有，就会返回socket对象，程序继续
        Socket socket = serverSocket.accept();
        //通过socket.getInputStream()获取客户端写入到数据通道的数据，并显示
        InputStream inputStream = socket.getInputStream();
        //IO读取，字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "jack";
        } else if ("hobby".equals(s)) {
            answer = "java";
        } else {
            answer = "你说的哈？";
        }
        //获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //使用字符输出流回发
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();//表示回复内容结束
        bufferedWriter.flush();
        //关闭
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}