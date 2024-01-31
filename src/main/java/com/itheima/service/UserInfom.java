package com.itheima.service;

import com.itheima.domin.pageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface UserInfom {
    //历史订单
    pageBean search(Integer page, Integer pageSize, String did, String sNumber,Integer sId);
    //个人订单
    pageBean mydan(Integer page, Integer pageSize,Integer sId);
    //待审核
    pageBean wack(Integer page, Integer pageSize,Integer sId);

    //待接单
    pageBean ware(Integer page, Integer pageSize,Integer sId);

    //未通过审核
    pageBean faile(Integer page,Integer pageSize,int id);

    List<Map<Object, Object>> shuju(Integer id);
}
