package com.tian.tankgame5;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    //在敌军坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    //增加成员，EnemyTank可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x,int y) {
        super(x,y);
    }
    //提供方法，将MyPanel的成员设置过来给EnemyTank
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克重叠或碰撞
    public boolean isTouchEnemyTank() {
        //判断当前敌人坦克（this）方向
        switch (this.getDirect()) {
            case 0://上
                //让当前敌人坦克和其他所有敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下 x范围 [enemyTank.getX(),enemyTank.getY() +40]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克左上角坐标【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克右上角坐标【this.getX() + 40,this.getY()】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左 x范围 [enemyTank.getX(),enemyTank.getY() +60]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //当前坦克左上角坐标【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克右上角坐标【this.getX() + 40,this.getY()】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX()  + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下 x范围 [enemyTank.getX(),enemyTank.getY() +40]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克右上角坐标【this.getX() + 60,this.getY()】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克右下角坐标【this.getX() + 60,this.getY() + 40】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左 x范围 [enemyTank.getX(),enemyTank.getY() +60]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //当前坦克右上角坐标【this.getX(),this.getY()】
                            if (this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克右下角坐标【this.getX() + 60,this.getY() +40】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下 x范围 [enemyTank.getX(),enemyTank.getY() +40]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克左下角坐标【this.getX(),this.getY() + 60】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克右下角坐标【this.getX() +40,this.getY() + 60】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左 x范围 [enemyTank.getX(),enemyTank.getY() +60]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //当前坦克左下角坐标【this.getX(),this.getY()+60】
                            if (this.getX()>= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克右下角坐标【this.getX() + 40,this.getY() +60】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下 x范围 [enemyTank.getX(),enemyTank.getY() +40]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克左上角坐标【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克左下角坐标【this.getX(),this.getY() + 40】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左 x范围 [enemyTank.getX(),enemyTank.getY() +60]
                        //y范围 [enemyTank.getY(),enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //当前坦克左上角坐标【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克左下角坐标【this.getX(),this.getY() +40】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        int step = ((int)(Math.random()*100));
        while (true) {
            //判断如果shots size =0,就创建一颗子弹放入集合，并启动
            if (shots.size() < 4 && isLive == true) {
                Shot s = null;
                //判断坦克方向，创建对应子弹
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20,getY(),0 );
                        break;
                    case 1:
                        s = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3:
                        s = new Shot(getX(),getY() + 20,3);
                        break;
                }
                //加入到集合中，并启动
                if (((int)((Math.random() + 1) * 10)) < 15) {
                    shots.add(s);
                    new Thread(s).start();
                }
            }
            //根据坦克方向继续移动
            switch (getDirect()) {
                case 0://上
                    //让坦克保持一个方向移动
                    for (int i = 0; i < step; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {
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
                        if (getX() + 80 < 800 && !isTouchEnemyTank()) {
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
                        if (getY() + 110 < 750 && !isTouchEnemyTank()) {
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
                        if (getX() > 0 && !isTouchEnemyTank()) {
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
