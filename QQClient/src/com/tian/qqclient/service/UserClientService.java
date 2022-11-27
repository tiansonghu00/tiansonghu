package com.tian.qqclient.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;
import com.tian.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
    //完成用户登录验证和用户注册等功能
    private User u = new User();//因为可能在其他地方要使用user信息，
    private Socket socket;
    public boolean checkUser(String userId,String pwd) {
        boolean b = false;
        //根据用户名和密码到服务器验证该用户是否合法
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        try {
            //连接到服务器，发送u对象
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象
            //读取从服务器端回复的message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//登录成功
                //创建一个和服务器端保持通信的线程
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                //启动客户端线程
                ccst.start();
                //将线程放到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,ccst);
                b = true;
            } else {//登录失败就不能启动线程
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    //向服务器端请求在线用户列表
    public void onlineFriendList() {
        //发送一个message，类型String MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器，得到当前线程的socket对应的ObjectOutputStream对象
        try {
            //从管理线程的集合中，通过userID得到线程
            ClientConnectServerThread ccst = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //通过当前这个线程得到关联的socket
            Socket socket = ccst.getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread
                    (u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);//发送一个message对象，向服务器要在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //编写方法，退出客户端，并给服务器端发送一个退出系统的message对象
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//一定要指定是哪个客户端id
        //发送message
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + "退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
