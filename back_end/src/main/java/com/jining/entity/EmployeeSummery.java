package com.jining.entity;

import lombok.Data;

/**
 * @ClassName Employee
 * @Author Goslly
 * @Date 2023/3/30 0:24
 * @Description 员工按类型的汇总信息
 */
@Data
public class EmployeeSummery {
    /*人员类型, 4：白名单*/
    private String person_type;
    /*此类型人员总数*/
    private int total;
}
