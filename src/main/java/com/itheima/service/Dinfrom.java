package com.itheima.service;

import com.itheima.domin.NumBer;
import com.itheima.domin.dingDan;
import com.itheima.domin.pageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Transactional
public interface Dinfrom {
    //下单
    Boolean dingDan(dingDan dinDan);
    //查询订单
    pageBean search(Integer page, Integer pageSize,String did,String sNumber,Integer id);

    //显示待审核
    List<dingDan> check();

    //填写原因
    void nopass(Integer eid,String reasion);
    //显示待揽收
    List<dingDan> serchbytype(Integer dtype,Integer id);
    //显示带派送
    List<dingDan> serchbytype1(Integer dtype,Integer id);

    //揽收
    void lanshou(Integer eid,Integer id);
    //派送
    void paidan(Integer eid);

    void rpaidan(Integer eid);
    //通过审核
    void pass(Integer eid);

    //禁用
    void ban(String znumber);

    pageBean getdan(Integer page, Integer pageSize);

    //接单
    void receivedan(Integer eid, Integer kuserid );

//    List<Map> shuju();
    CompletableFuture<List<Map<Object, Object>>> shuju();

    CompletableFuture<List<Integer>> totalUser();

    CompletableFuture<List<Integer>> totalGuser();
//
    CompletableFuture<List<Integer>> totalKuser();

    CompletableFuture<List<Integer>>totalExpre();


}
