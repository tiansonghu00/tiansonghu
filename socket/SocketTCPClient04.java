package com.tian.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient04 {
    public static void main(String[] args) throws Exception {
        //客户端发送一张图片，接到回复后退出
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //创建读取磁盘文件的输入流
        String filePath = "e:\\th.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes就是filePath对应的文件字节
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //通过socket获取输出流，将数据bytes发给服务器
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组内容，写入到数据通道
        bis.close();
        socket.shutdownOutput();//结束标记
        //接收服务器端的回复
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        //关闭流
        inputStream.close();
        bos.close();
        socket.close();
    }
}
