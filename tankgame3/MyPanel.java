package com.tian.tankgame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了监听键盘事件，实现KeyListener
//为了让Panel不停的重绘子弹，需要将MyPanel实现Runnable，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
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
            //给enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60,enemyTank.getDirect());
            //加入enemyTank的vector成员
            enemyTank.shots.add(shot);
            new Thread(shot).start();
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
            //取出敌方坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive == true) {
                drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive == true) {
                        g.draw3DRect(shot.x,shot.y,2,2,false);
                    } else {
                        enemyTank.shots.remove(shot);//移除子弹
                    }
                }
            }
        }
        //画出发出的子弹
        if (myTank.shot != null && myTank.shot.isLive != false) {
            g.draw3DRect(myTank.shot.x,myTank.shot.y,2,2,false);
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
    //编写方法，判断我方子弹是否击中敌人
    public static void hitTank(Shot s,EnemyTank enemyTank) {
        //判断s击中坦克
        switch (enemyTank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //enemyTanks.remove(enemyTank);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //enemyTanks.remove(enemyTank);
                }
                break;
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
        //如果按下J，就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {//按下J键
            myTank.shotEnemyTank();
        }
        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔一定时间，重绘，实现子弹移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中了敌人
            if (myTank.shot != null && myTank.shot.isLive == true) {
                //遍历所有的敌人
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(myTank.shot,enemyTank);
                }
            }
            this.repaint();
        }
    }
}
