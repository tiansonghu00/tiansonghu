package com.tian.qqclient.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MessageClientService {
    //该类提供和消息相关的服务方法
    /**
     *
     * @param content 内容
     * @param senderId 发送方id
     * @param getterId 接收方id
     */
    public void sendMessageToOne(String content,String senderId,String getterId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COME_MES);//普通聊天消息
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对" + getterId + "说" + content);
        //发送给服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMessageToAll(String content,String senderId) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发聊天消息
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对大家说" + content);
        //发送给服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
