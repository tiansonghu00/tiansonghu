package com.tian.tankgame4;

public class Tank {
    private int x;//坦克横坐标
    private int y;//坦克纵坐标
    private int direct;//direct表示方向0向上 1向右 2向下 3向左
    private int speed = 2;//坦克速度
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //上右下左移动方法
    public void moveUp() {
        y -= speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
