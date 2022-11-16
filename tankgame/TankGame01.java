package com.tian.tankgame;

import javax.swing.*;

public class TankGame01 extends JFrame{
    //定义MyPanel
    MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }
    public TankGame01() {
        myPanel = new MyPanel();
        this.add(myPanel);//把面板也就是游戏的绘图区域添加
        this.setSize(800,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
