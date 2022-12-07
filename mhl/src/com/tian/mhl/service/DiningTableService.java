package com.tian.mhl.service;

import com.tian.mhl.dao.DiningTableDAO;
import com.tian.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    //定义一个diningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();
    //返回所有餐桌信息
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id,state from diningTable", DiningTable.class);
    }
    //根据id，查询对应的餐桌对象，返回null，表示不存在
    public DiningTable getDiningTableById(int id) {
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class,id);
    }
    //如果餐桌可以预定，调用方法对状态进行更新
    public boolean orderDiningTable(int id,String orderName,String orderTel) {
        int update = diningTableDAO.update("update diningTable set state = '已经预定',orderName = ?,orderTel = ? where id = ?",orderName,orderTel,id);
        return update > 0;
    }
    //需要提供一个更新餐桌状态的方法
    public boolean updateDiningTableState(int id,String state) {
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?",state,id);
        return update > 0;
    }
    //将餐桌置为空闲状态
    public boolean updateDiningTableToFree(int id,String state) {
        int update = diningTableDAO.update("update diningTable set state = ?,orderName = '',orderTel = '' where id = ?",state,id);
        return update > 0;
    }
}
