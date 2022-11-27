package com.tian.qqserver.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;
import com.tian.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    //监听端口，等待客户端链接，并保持通信
    private ServerSocket ss = null;
    //也可以使用ConcurrentHashMap.可以处理并发的集合，乜有线程安全
    //使用集合，存放多个用户，这些用户都可以登录,ConcurrentHashMap处理的线程安全
    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap<>();
    static {//在静态代码块，初始化validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("孙悟空",new User("孙悟空","123456"));
        validUsers.put("孙大圣",new User("孙大圣","123456"));
    }
    //验证用户是否有效的方法
    private boolean checkUser(String userId,String passwd) {
        User user = validUsers.get(userId);
        if (user == null) {//说明userID没有存在集合中
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {//userId正确，密码错误
            return false;
        }
        return true;
    }
    public QQServer() {
        try {
            System.out.println("服务端在9999端口监听");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9999);
            while (true) {//建立链接后，会继续监听
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取客户端发送的user对象
                //创建一个message对象，准备回复客户端
                Message message = new Message();
                //验证
                if (checkUser(u.getUserId(),u.getPasswd())) {//登陆成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象发送回复
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通讯,该线程需要持有socket对象
                    ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    scct.start();
                    //放入集合中，进行管理
                    ManageClientThreads.addServerConnectClientThread(u.getUserId(),scct);
                } else {//登录失败
                    System.out.println("用户ID=" + u.getUserId() + "pwd=" + u.getPasswd() + "验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果客户端退出了循环，说明服务端不再监听，要关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
