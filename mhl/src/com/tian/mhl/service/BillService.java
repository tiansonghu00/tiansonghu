package com.tian.mhl.service;

import com.tian.mhl.dao.BillDAO;
import com.tian.mhl.dao.MultiTableDAO;
import com.tian.mhl.domain.Bill;
import com.tian.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

public class BillService {
    //处理和账单相关业务
    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();
    //生成账单，需要更新餐桌状态
    public boolean orderMenu(int menuId,int nums,int diningTableId) {
        //生成一个账单号
        String billID = UUID.randomUUID().toString();
        //将账单生成到bill表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billID,menuId,nums,menuService.getMenuById(menuId).getPrice() * nums,diningTableId);
        if (update <= 0) {
            return false;
        }
        //更新对应餐桌属性
        return diningTableService.updateDiningTableState(diningTableId,"就餐中");
    }
    //返回所有的账单
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }
    //返回所有账单，并带有菜品名,价格
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId = menu.id", MultiTableBean.class);
    }
    //查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' limit 0,1",Bill.class,diningTableId);
        return bill != null;
    }
    //完成结账
    public boolean payBill(int diningTableId,String payMode) {
        //修改bill表
        int update = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'", payMode, diningTableId);
        if (update <= 0) {
            return false;
        }
        //修改diningTable表
        if (diningTableService.updateDiningTableToFree(diningTableId,"空")) {
            return false;
        }
        return true;
    }

}
