package com.tian.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel{
    //坦克大战绘图区
    //定义我的坦克
    MyTank myTank = null;
    public MyPanel() {
        myTank = new MyTank(100,100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,800,750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(myTank.getX(),myTank.getY(),g,0,0);
        drawTank(myTank.getX() + 60,myTank.getY(),g,0,1);
    }
    //编写方法，画出坦克
    /**
     *
     * @param x 坦克左上角x坐标
     * @param y 坦克右上角y坐标
     * @param g 画笔
     * @param direct 坦克方向
     * @param type 坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌军
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向，来绘制坦克
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x,y,10,60,false);//左边履带
                g.fill3DRect(x + 30,y,10,60,false);//右边履带
                g.fill3DRect(x + 10,y + 10,20,40,false);//坦克舱
                g.fillOval(x + 10,y + 20,20,20);//坦克盖子
                g.drawLine(x + 20,y,x + 20,y + 30);//炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
