package com.tian.mhl.service;

import com.tian.mhl.dao.EmployeeDAO;
import com.tian.mhl.domain.Employee;

public class EmployeeService {
    //该类完成对employee表的各种操作（通过调用EmployeeDAO对象完成）
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //根据账号和密码，返回一个employee对象
    public Employee getEmployeeByIdAndPwd(String empId,String pwd) {
        return employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
    }
}
