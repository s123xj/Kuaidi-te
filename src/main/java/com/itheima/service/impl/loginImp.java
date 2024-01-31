package com.itheima.service.impl;

import com.itheima.dao.*;
import com.itheima.domin.Guser;
import com.itheima.domin.KUser;
import com.itheima.domin.User;
import com.itheima.domin.dingDan;
import com.itheima.service.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginImp implements login {
    @Autowired
    private user us;
    @Autowired
    private kUser ku;
    @Autowired
    private adMin am;
    @Autowired
    private dingdan dan;
    @Autowired
    private guser gs;
    @Autowired
    private zhuCe zc;
    //登入
    @Override
    public User ulogin(String name, String password) {
        User ulogin = us.ulogin(name, password);

        return ulogin;
    }
    //管理员登入

    @Override
    public Guser glogin(String gPhnumber, String password) {
        Guser ulogin = gs.glogin(gPhnumber,password);
        return ulogin;
    }

    //快递员登入
    @Override
    public KUser klogin(String znumber,String passward) {
        return  ku.klogin(znumber,passward);
    }

    //查询用户信息
    @Override
    public User search(String name){
        return us.searchall(name);
    }

    //查找员工信息
    @Override
    public List<KUser> kSearch(){
        return ku.K_USERS();
    }

    //根据账号删除员工
    @Override
    public void deletebyid(String znumber) {
        ku.deleteByid(znumber);
    }
    //增加员工
    @Override
    public Boolean addinfrom(KUser kUser) {
        return am.addinform(kUser);
    }

    //注册员工
    @Override
    public Boolean zhuce(User user) {
        return zc.zhuce(user);
    }

    //用户根据订单号查询订单信息
    @Override
    public List<dingDan> searbyid(String did) {
        return dan.serchbyid(did);
    }

}
