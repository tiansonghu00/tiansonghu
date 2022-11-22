package com.tian.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame05 extends JFrame{
    //定义MyPanel
    MyPanel myPanel = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TankGame05 tankGame01 = new TankGame05();
    }
    public TankGame05() {
        System.out.println("请输入选择 1：新游戏 2：继续游戏");
        String key = scanner.next();
        myPanel = new MyPanel(key);
        //将myPanel放入到Thread,并启动
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);//把面板也就是游戏的绘图区域添加
        this.setSize(800,750);
        this.addKeyListener(myPanel);//让JFrame监听键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
