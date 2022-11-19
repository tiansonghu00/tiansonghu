package com.tian.tankgame4;

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
    //定义一个Vector,用于存放炸弹,当子弹击中坦克时，就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;
    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel() {
        myTank = new MyTank(200,200);//初始化自己的坦克
        myTank.setSpeed(6);
        //初始化敌军坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);
            //启动敌人机动线程
            new Thread(enemyTank).start();
            //给enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60,enemyTank.getDirect());
            //加入enemyTank的vector成员
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.png"));
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
        //保证第一个坦克爆炸图片可以加载
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            //根据当前bomb对象的life值去画对应图片
            if (bomb.life > 6) {
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            } else if (bomb.life > 3) {
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            } else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.liefDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
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
    public void hitTank(Shot s, EnemyTank enemyTank) {
        //判断s击中坦克
        switch (enemyTank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);//移除尸体
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
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
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//按下D键
            myTank.setDirect(1);
            if (myTank.getX() + 80 < 800) {
                myTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//按下S键
            myTank.setDirect(2);
            if (myTank.getY() + 110< 750) {
                myTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//按下A键
            myTank.setDirect(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
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
