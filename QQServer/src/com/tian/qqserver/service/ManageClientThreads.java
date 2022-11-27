package com.tian.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThreads {
    //管理客户和客户端通信的线程
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();
    //将某个线程加入到集合中
    public static void addServerConnectClientThread(String userId,ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId,serverConnectClientThread);
    }
    //通过userid，可以得到对一个线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }
    //编写方法，从集合中移除某个线程对象
    public static void removeServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //编写方法，可以返回在线用户列表
    public static String getOnlineUser() {
        //集合遍历,遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList +=  iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
}
