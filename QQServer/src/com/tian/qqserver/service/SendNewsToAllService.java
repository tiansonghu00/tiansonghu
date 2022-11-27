package com.tian.qqserver.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;
import com.tian.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SendNewsToAllService implements Runnable{
    //推送新闻给所有人
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        //为了可以推送多次，使用while
        while (true) {
            System.out.println("请输入要推送的消息/新闻[输入exit退出推送]");
            String news = Utility.readString(1000);
            if ("exit".equals(news)) {
                break;
            }
            //构建一个消息，群发消息
            Message message = new Message();
            message.setSender("服务器");
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人，说：" + news);
            //遍历当前所有通信线程，得到socket，并发送message
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next().toString();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
