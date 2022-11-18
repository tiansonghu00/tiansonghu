package com.tian.tankgame2;

import javax.swing.*;

public class TankGame02 extends JFrame{
    //定义MyPanel
    MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame02 tankGame01 = new TankGame02();
    }
    public TankGame02() {
        myPanel = new MyPanel();
        this.add(myPanel);//把面板也就是游戏的绘图区域添加
        this.setSize(800,750);
        this.addKeyListener(myPanel);//让JFrame监听键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
