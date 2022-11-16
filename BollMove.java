package com.tian.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BollMove extends JFrame{
    //通过键盘控制小球上下左右移动
    MyPanel myPanel = null;
    public static void main(String[] args) {
        BollMove bollMove = new BollMove();
    }
    public BollMove() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400,300);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//面板
//KeyListener是监听器,监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //有字符输出时，该方法会触发
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //当某个键按下，该方法会触发
        //在Java中，会给每一个键都分配一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN就是向下的箭头对应的code
            y += 3;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 3;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 3;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 3;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //当某个键松开了，该方法会触发
    }
}
