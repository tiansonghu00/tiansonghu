package com.tian.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient03 {
    //使用字符流方法
    public static void main(String[] args) throws IOException {
        //客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端" + socket.getClass());
        //连接上后，生成socket，通过socket.getOutputStream(),得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello server");
        bufferedWriter.newLine();//加入一个换行符，表示写入的内容结束。要求对方使用readLine()
        bufferedWriter.flush();//字符流需要手动刷新，否则不会写入数据通道
        //获取和socket关联的输入流，读取数据(字节)并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭流对象和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
