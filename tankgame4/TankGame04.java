package com.tian.tankgame4;

import javax.swing.*;

public class TankGame04 extends JFrame{
    //定义MyPanel
    MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame04 tankGame01 = new TankGame04();
    }
    public TankGame04() {
        myPanel = new MyPanel();
        //将myPanel放入到Thread,并启动
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);//把面板也就是游戏的绘图区域添加
        this.setSize(800,750);
        this.addKeyListener(myPanel);//让JFrame监听键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
