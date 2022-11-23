package com.tian.homework20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        //发送端B，向接收端发送数据，收到回复，
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据封装到对象中
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question = scanner.next();
        byte[] bytes = question.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName("192.168.3.17"),9999);
        socket.send(packet);
        //接收回复
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf,buf.length);
        //调用接收方法，准备接收,填充到packet
        socket.receive(packet);
        //把packet进行拆包，取出数据，并显示
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data,0,length);
        System.out.println(s);
        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
