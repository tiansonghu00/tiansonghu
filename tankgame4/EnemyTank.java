package com.tian.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    //在敌军坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x,int y) {
        super(x,y);
    }

    @Override
    public void run() {
        int step = ((int)(Math.random()*100));
        while (true) {
            //根据坦克方向继续移动
            switch (getDirect()) {
                case 0://上
                    //让坦克保持一个方向移动
                    for (int i = 0; i < step; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://右
                    for (int i = 0; i < step; i++) {
                        if (getX() + 80 < 800) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://下
                    for (int i = 0; i < step; i++) {
                        if (getY() + 110 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://左
                    for (int i = 0; i < step; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //然后随机改变坦克方向0-3
            setDirect((int)(Math.random() * 4));
            //何时退出
            if (isLive == false) {
                break;
            }
        }
    }
}
