package src.main.com.tian.houserent.service;

import src.main.com.tian.houserent.domain.House;

public class HouseService {
    //响应HouseView的调用，完成对房屋信息的操作CRUD增删改查
    private House houses[];
    private int houseNum = 1;//记录房屋数量
    private int idCounter = 1;//记录当前id自增长到哪里
    //构造器
    public HouseService(int size) {
        houses = new House[size];//当创建对象时，指定数组大小
        houses[0] = new House(1,"jack","157","任城区",1500,"未出租");
    }
    //findById方法
    public House findById(int findId) {
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }
    //del
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNum -1; i++) {
            houses[i] = houses[i+1];
        }
        houses[houseNum - 1] = null;
        houseNum--;
        return true;
    }
    //add
    public boolean add(House newHouse) {
        //判断是否可以继续添加
        if (houseNum == houses.length) {
            System.out.println("数组已满，不能加了");
            return false;
        }
        houses[houseNum] = newHouse;//把对象加入到数组最后
        houseNum++;
        idCounter++;
        newHouse.setId(idCounter);
        return true;
    }
    //list方法，返回
    public House[] list() {
        return houses;
    }
}
