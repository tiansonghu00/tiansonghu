package com.tian.mhl.service;

import com.tian.mhl.dao.MenuDAO;
import com.tian.mhl.domain.Menu;

import java.util.List;

public class MenuService {
    //完成对menu表的各种操作
    private MenuDAO menuDAO = new MenuDAO();
    //返回所有菜品，给界面
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
    //根据id，返回menu对象
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class,id);
    }
}
