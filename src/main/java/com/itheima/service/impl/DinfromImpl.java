package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.dingdan;
import com.itheima.dao.kUser;
import com.itheima.domin.dingDan;
import com.itheima.domin.pageBean;
import com.itheima.service.Dinfrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class DinfromImpl implements Dinfrom {

    @Autowired
    private dingdan dingdan;
    @Autowired
    private kUser kUser;
    //下单
    @Override
    public Boolean dingDan(dingDan dinDan) {
        return dingdan.inserding(dinDan);
    }

    // 分页查询
    @Override
    public pageBean search(Integer page, Integer pageSize,String did,String sNumber,Integer id) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list=dingdan.dingdan(did,sNumber,id);
        //强转为page类型
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    //显待审核
    @Override
    public List<dingDan> check() {
        return dingdan.check();
}

    @Override
    public void nopass(Integer eid,String reasion) {
          dingdan.nopass(eid,reasion);
    }

    //显示待揽收
    @Override
    public List<dingDan> serchbytype(Integer dtype,Integer id) {
        return dingdan.serchbytype(dtype,id);
    }

    //显示待派送
    @Override
    public List<dingDan> serchbytype1(Integer dtype,Integer id) {
        return dingdan.serchbytype1(dtype,id);
    }

    //揽收
    @Override
    public void lanshou(Integer eid,Integer id) {
        dingdan.lanshou(eid,id);
    }

    //派单
    @Override
    public void paidan(Integer eid) {
        dingdan.paisong(eid);
    }

    //重新派单
    @Override
    public void rpaidan(Integer eid) {
        dingdan.rpaidan(eid);
    }

    @Override
    public void pass(Integer eid) {
        dingdan.pass(eid);
    }

    //禁用
    @Override
    public void ban(String znumber) {
        dingdan.ban(znumber);
    }

    //获取待接单的订单
    @Override
    public pageBean getdan(Integer page, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<dingDan> list=kUser.getdan();
        //强转为page类型
        Page<dingDan> p=(Page<dingDan>) list;
        //封装pageBean
        pageBean pageBean=new pageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void receivedan(Integer eid, Integer kuserid ) {
        kUser.receivedan(eid,kuserid);
    }


    @Override
    @Async("first")
    public CompletableFuture<List<Map<Object, Object>>> shuju() {
        List<Map<Object, Object>> list =dingdan.shuju();
        return CompletableFuture.completedFuture(list);
    }

    @Override
    @Async("first")
    public CompletableFuture<List<Integer>> totalUser() {
        List<Integer> integer = dingdan.totalUser();
        return CompletableFuture.completedFuture(integer);
    }

    @Override
    @Async("first")
    public CompletableFuture<List<Integer>> totalGuser() {
        List<Integer> integer2 = dingdan.totalGuser();

        return CompletableFuture.completedFuture(integer2);
    }

    @Override
    @Async("first")
    public CompletableFuture<List<Integer>> totalKuser() {
        List<Integer> integer1 = dingdan.totalKuser();
        return CompletableFuture.completedFuture(integer1);
    }

    @Override
    @Async("first")
    public CompletableFuture<List<Integer>> totalExpre() {
        List<Integer> integer3 = dingdan.totalExpre();
        return CompletableFuture.completedFuture(integer3);
    }


}
