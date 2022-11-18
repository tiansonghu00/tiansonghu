package com.tian.tankgame3;

public class MyTank extends Tank{
    Shot shot = null;
    public MyTank(int x, int y) {
        super(x, y);
    }
    //定义一个Shot对象，表示一个射击线程
    public void shotEnemyTank() {
        //创建shot对象,根据当前坦克的位置和方向来创建shot
        switch (getDirect()) {
            case 0://向上
                shot = new Shot(getX() + 20,getY(),0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60,getY() + 20,1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20,getY() + 60,2);
                break;
            case 3://向左
                shot = new Shot(getX(),getY() + 20,3);
                break;
        }
        new Thread(shot).start();

    }
}
