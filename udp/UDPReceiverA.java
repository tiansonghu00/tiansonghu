package com.tian.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //接收端A，在9999端口等待接收数据，接收到数据后回复，退出
        DatagramSocket socket = new DatagramSocket(9999);
        //构建一个对象，准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //调用接收方法，准备接收,填充到packet
        System.out.println("A等待接收数据");
        socket.receive(packet);
        //把packet进行拆包，取出数据，并显示
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data,0,length);
        System.out.println(s);
        //回复信息给B
        data = "好的".getBytes();
        packet = new DatagramPacket(data, data.length,
                InetAddress.getByName("192.168.3.17"),9998);
        socket.send(packet);
        //关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
