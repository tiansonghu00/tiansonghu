package com.tian.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了监听键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //坦克大战绘图区
    //定义我的坦克
    MyTank myTank = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;;
    public MyPanel() {
        myTank = new MyTank(500,500);//初始化自己的坦克
        myTank.setSpeed(2);
        //初始化敌军坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,800,750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(myTank.getX(),myTank.getY(),g,myTank.getDirect(),0);
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
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
        //direct表示方向0向上 1向右 2向下 3向左
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x,y,10,60,false);//左边履带
                g.fill3DRect(x + 30,y,10,60,false);//右边履带
                g.fill3DRect(x + 10,y + 10,20,40,false);//坦克舱
                g.fillOval(x + 10,y + 20,20,20);//坦克盖子
                g.drawLine(x + 20,y,x + 20,y + 30);//炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x,y,60,10,false);//左边履带
                g.fill3DRect(x,y + 30,60,10,false);//右边履带
                g.fill3DRect(x + 10,y + 10,40,20,false);//坦克舱
                g.fillOval(x + 20,y + 10,20,20);//坦克盖子
                g.drawLine(x + 30,y + 20,x + 60,y + 20);//炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x,y,10,60,false);//左边履带
                g.fill3DRect(x + 30,y,10,60,false);//右边履带
                g.fill3DRect(x + 10,y + 10,20,40,false);//坦克舱
                g.fillOval(x + 10,y + 20,20,20);//坦克盖子
                g.drawLine(x + 20,y + 30,x + 20,y + 60);//炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x,y,60,10,false);//左边履带
                g.fill3DRect(x,y + 30,60,10,false);//右边履带
                g.fill3DRect(x + 10,y + 10,40,20,false);//坦克舱
                g.fillOval(x + 20,y + 10,20,20);//坦克盖子
                g.drawLine(x + 30,y + 20,x,y + 20);//炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //处理wdsa键按下情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变坦克方向
            myTank.setDirect(0);
            //修改坦克坐标
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//按下D键
            myTank.setDirect(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//按下S键
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//按下A键
            myTank.setDirect(3);
            myTank.moveLeft();
        }
        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
