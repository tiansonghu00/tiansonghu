package com.tian.tankgame3;

import java.util.Vector;

public class EnemyTank extends Tank {
    //在敌军坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x,int y) {
        super(x,y);
    }
}
