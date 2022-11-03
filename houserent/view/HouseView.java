package src.main.com.tian.houserent.view;

import src.main.com.tian.houserent.domain.House;
import src.main.com.tian.houserent.service.HouseService;
import src.main.com.tian.houserent.utils.Utility;

public class HouseView {
    //显示界面，接收用户输入，调用其他类完成对房屋信息的操作
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);//设置数组大小
    //退出
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }
    //根据id,修改房屋信息
    public void update() {
        System.out.println("=======修改房屋信息=======");
        System.out.println("请输入待修改房屋编号（-1退出）：");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("=======你放弃了修改=======");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("=======修改的房屋信息编号不存在=======");
            return;
        }
        System.out.print("姓名("+house.getName()+")：");
        String name = Utility.readString(8,"");//如果直接回车，表示不修改，默认空串
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话("+house.getPhone()+")：");
        String phone = Utility.readString(12,"");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址("+house.getAddress()+")：");
        String address = Utility.readString(16,"");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金("+house.getRent()+")：");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态("+house.getState()+")：");
        String state = Utility.readString(3,"");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=======修改的房屋信息成功=======");
    }
    //根据id,查找房屋信息
    public void findHouse() {
        System.out.println("=======查找房屋信息=======");
        System.out.println("输入要查找的id");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("=======查找房屋信息id不存在=======");
        }
    }
    //编写方法delHouse()接收id，调用del方法
    public void delHiuse() {
        System.out.println("=======删除房屋信息=======");
        System.out.println("请输入待删除房屋编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("=======你放弃了删除=======");
            return;
        }
        char choice = Utility.readConfirmSelection();//本身就有循环判断
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("=======删除房屋信息成功=======");
            } else {
                System.out.println("=======删除房屋信息失败=======");
            }
        } else {
            System.out.println("=======你放弃了删除=======");
        }
    }
    //编写方法addHouse()接收，创建对象，调用add方法
    public void addHouse() {
        System.out.println("=======添加房屋=======");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(15);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        //创建一个新的HOUSE对象
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("=======添加房屋成功=======");
        } else {
            System.out.println("=======添加房屋失败=======");
        }
    }
    //listHouses()，显示房屋列表
    public void listHouses() {
        System.out.println("=======房屋列表=======");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House houses[] = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("============房屋列表显示完毕============");
    }
    public void mainView() {
        do {
            System.out.println("============房屋出租系统菜单============");
            System.out.println("\t\t\t1.新 增 房 源");
            System.out.println("\t\t\t2.查 找 房 屋");
            System.out.println("\t\t\t3.删 除 房 屋");
            System.out.println("\t\t\t4.修 改 房 屋 信 息");
            System.out.println("\t\t\t5.房 屋 列 表");
            System.out.println("\t\t\t6.退      出");
            System.out.println("请输入你的选择（1-6）：");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    addHouse();
                    break;
                case '2' :
                    findHouse();
                    break;
                case '3' :
                    delHiuse();
                    break;
                case '4' :
                    update();
                    break;
                case '5' :
                    listHouses();
                    break;
                case '6' :
                    exit();
                    break;
            }
        }while (loop);
    }
}
