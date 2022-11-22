package com.tian.tankgame6;

public class Shot implements Runnable{
    int x;//子弹坐标
    int y;
    int direct = 0;//子弹方向
    int speed = 4;//子弹速度
    boolean isLive = true;//子弹是否还存在

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向来改变x,y坐标
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://右
                    x -= speed;
                    break;
            }
            //子弹移动到面板边界，就应该销毁（把启动的子弹的线程销毁）.碰到敌人坦克，也结束
            if (!(x >= 0 && x <= 800 && y >= 0 && y <= 750 && isLive == true)) {
                isLive = false;
                break;
            }
        }
    }
}
