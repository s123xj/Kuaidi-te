package com.itheima.utils;

public class loginutils {
    public static Boolean phnumber(String phnumber){
        //手机号规则判断
        boolean flag = phnumber.matches("^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-79])|(?:5[0-35-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[189]))\\d{8}$");
        return flag;
    }

    public static Boolean passward(String passward){
        //密码校验 字母开头 6~10位
        boolean flag = passward.matches("[a-zA-Z]\\d{5,9}");
        return flag;
    }



}
