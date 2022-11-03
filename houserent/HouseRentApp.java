package src.main.com.tian.houserent;

import src.main.com.tian.houserent.domain.House;
import src.main.com.tian.houserent.view.HouseView;

public class HouseRentApp {
    //创建对象，调用，显示主菜单
    public static void main(String[] args) {
        new HouseView().mainView();
        System.out.println("===你退出了房屋出租系统");
    }
}
