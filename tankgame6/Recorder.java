package com.tian.tankgame6;

import java.io.*;
import java.util.Vector;

public class Recorder {
    //定义变量，记录我方击毁敌人坦克数量
    private static int allEnemyTankNum = 0;
    //定义IO对象
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    //把记录文件保存在src
    private static String recordFile = "src\\myRecord.txt";
    //定义Vector,指向MyPanel对象的敌人坦克
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector,用于保存敌人的信息node
    private static Vector<Node> nodes = new Vector<>();
    //返回记录文件的目录
    public static String getRecordFile() {
        return recordFile;
    }
    //增加一个方法，用于读取recordFile，恢复相关信息
    //该方法，在继续上局游戏的时候调用
    public static Vector<Node> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //增加一个方法，游戏退出时，将allEnemyTankNum保存
    //对该方法进行升级，保存敌人坦克坐标和方向
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");
            //遍历敌人坦克的集合，然后保存
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive == true) {
                    //保存该坦克信息
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }
    //当我方坦克击毁一个敌人坦克，就应当++
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}
