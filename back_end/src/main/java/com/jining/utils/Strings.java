package com.jining.utils;


import com.jining.errors.ErrorCodeEnum;
import com.jining.exception.BizException;

public class Strings {
    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return boolean
     * @author Goslly
     * @date 1:18 2022/10/30
     **/
    public static boolean isBlank(final String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * string转Integer函数
     * 若为空，返回null
     *
     * @param str 需要转换的字符串
     * @return
     */
    public static Integer shiftInteger(String str) {
        Integer num;
        try {
            num = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
        return num;
    }

    public static Integer objShiftInteger(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return Integer.valueOf(String.valueOf(obj));
        }
    }

    /**
     * @param str [1479.6265759896835]
     * @return 1479.63
     */
    public static String strDeal(String str) {
        int size = str.length();
        str = str.substring(1, size - 1);
        return String.format("%.2f", Double.parseDouble(str));
    }

    /**
     * 将字符串转为的str，若为空，返回null，若非double类型，返回null
     *
     * @param str
     * @return
     */
    public static Double strShiftDouble(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double strShiftDouble2(String str){
        if (str == null | str.length() == 0) {
            return null;
        }
        try {
            return Double.parseDouble(str);
        }catch (Exception e) {
            throw new BizException(ErrorCodeEnum.FORMAT_ERROR);
        }
    }

    public static Double scopeShiftAve(String str) {
        if (str == null | str.length() == 0){
            return null;
        }
        String[] split = str.split("-");
        Double down = strShiftDouble(split[0]);
        Double upper = strShiftDouble(split[1]);
        return (down + upper) / 2;
    }

    public static String formatStr(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("['");
        sb.append(str);
        sb.append("_price']");
        return sb.toString();
    }

    public static String colFormatStr(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_price");
        return sb.toString();
    }

    public static Double getTwoDoule(String str){
        Double num = Double.parseDouble(str);
        return Double.parseDouble(String.format("%.2f", num));
    }
}
