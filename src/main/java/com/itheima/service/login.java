package com.itheima.service;

import com.itheima.domin.Guser;
import com.itheima.domin.KUser;
import com.itheima.domin.User;
import com.itheima.domin.dingDan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface login {
    //用户登入
    User ulogin(String name,String password);
    //管理员登入
    public Guser glogin(String gPhnumber, String password);
    //快递员登入
    KUser klogin(String znumber,String passward);
    //根据用户名查找用户信息
    User search(String name);
    //查找员工信息
    List<KUser> kSearch();
    //根据账号删除员工信息
    void deletebyid(String zname);
    //增加员工
    Boolean addinfrom(KUser kUser);
    //用户注册
    Boolean zhuce(User user);
    //用户根据订单号查询订单
    List<dingDan> searbyid(String did);
}
