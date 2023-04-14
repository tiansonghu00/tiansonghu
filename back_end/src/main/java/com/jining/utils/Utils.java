package com.jining.utils;

import com.jining.errors.ErrorCodeEnum;
import com.jining.exception.BizException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2023-02-01 18:44
 * @description
 */
public class Utils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 分页参数计算
     * 根据传入的总数，每页大小，返回参数Map
     *
     * @param total    数据总数
     * @param pageSize 每页大小
     * @return
     */
    public static Map<String, Object> getPageParams(int total, int pageSize) {
        int pageNum = (int) Math.ceil((double) total / pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("total", total);
        params.put("pageSize", pageSize);
        params.put("pageNum", pageNum);
        return params;
    }

    /**
     * string转为LocalDate
     * @param str
     * @return
     */
    public static LocalDate strShiftLocalDate(String str) {
        try {
            return LocalDate.parse(str, FORMATTER);
        }catch (Exception e){
            throw new BizException(ErrorCodeEnum.DATE_SHIFT_ERROR);
        }
    }

    /**
     * LocalDate转String
     * @param date
     * @return
     */
    public static String localDateShiftStr(LocalDate date){
        try{
            return date.format(FORMATTER);
        }catch (Exception e){
            throw new BizException(ErrorCodeEnum.DATE_SHIFT_ERROR);
        }
    }
}
