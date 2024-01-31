package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.dingdan;
import com.itheima.dao.user;
import com.itheima.domin.dingDan;
import com.itheima.domin.pageBean;
import com.itheima.service.UserInfom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfomImpl implements UserInfom {
    @Autowired
    private user us;
    // 分页条件查询
    @Override
    public pageBean search(Integer page, Integer pageSize, String did, String sNumber,Integer sId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list= us.history(did, sNumber,sId);
        //强转为page类型
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public pageBean mydan(Integer page, Integer pageSize, Integer sId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list= us.mydan(sId);
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public pageBean wack(Integer page, Integer pageSize, Integer sId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list= us.wack(sId);
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public pageBean ware(Integer page, Integer pageSize, Integer sId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list= us.ware(sId);
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public pageBean faile(Integer page,Integer pageSize,int id) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list= us.faile(id);
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public List<Map<Object, Object>> shuju(Integer id) {
        return us.shuju(id);
    }
}
