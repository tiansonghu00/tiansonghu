package com.tian.qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    //管理客户端链接到服务器端的线程的类
    //把多个线程放入到集合中，key就是用户的id，value就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();
    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId,clientConnectServerThread);
    }
    //通过userid，可以得到对一个线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }
}
