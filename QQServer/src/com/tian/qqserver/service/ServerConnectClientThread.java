package com.tian.qqserver.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread{
    //该类对应的对象和客户端保持通讯
    private Socket socket;
    private String userId;//连接到客户端用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//可以发送和接收消息
        //因为Thread需要在后台和服务器通信，因此需要while循环
        while (true) {
            try {
                System.out.println("服务端和客户" + userId + "保持通信，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//如果服务器端没有发送，线程会阻塞
                //根据message的类型做相应业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + "要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message对象，返回客户端
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());
                    //写入到数据通道。返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                } else if (message.getMesType().equals(MessageType.MESSAGE_COME_MES)) {
                    //根据message获取getterId,然后再得到对应的线程
                    ServerConnectClientThread scct = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //得到对应socket的对象输出流，将message对象转发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(scct.getSocket().getOutputStream());
                    oos.writeObject(message);//转发
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //需要遍历管理线程的集合，把所有线程的socket得到，然后把message转发
                    HashMap<String,ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户id
                        String onLineUserId =  iterator.next().toString();
                        if (!onLineUserId.equals(message.getSender())) {//排除群发消息的这个用户
                            //进行转发message
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getter id获取对应线程，将message对象转发
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "退出");
                    //将客户端对应的线程，从集合删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    //退出
                    break;
                } else {
                    System.out.println("其他类型的message，暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
