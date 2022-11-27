package com.tian.qqclient.service;

import com.tian.qqcommon.Message;
import com.tian.qqcommon.MessageType;

import java.io.*;

public class FileClientService {
    //完成文件传输服务

    /**
     * @param src 源文件
     * @param dest 把文件传到哪里
     * @param sendId 发送用户id
     * @param getterId 接收用户id
     */
    public void sendFileToOne(String src,String dest,String sendId,String getterId) {
        //读取src文件
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);
        //需要将文件读取
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int) new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);//将src文件读入到程序的字节数组
            //将文件对应的字节数组设置message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //提示信息
        System.out.println("\n" + sendId + "给" + getterId + "发送文件" + src + "到对方电脑目录" + dest);
        //发送
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
