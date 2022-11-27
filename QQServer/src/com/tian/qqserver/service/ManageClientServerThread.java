package com.tian.qqserver.service;

import java.util.HashMap;

public class ManageClientServerThread {
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
}
