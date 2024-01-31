package com.itheima.dao;

import com.itheima.domin.NumBer;
import com.itheima.domin.dingDan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Mapper
@Repository
public interface dingdan {

    //@Select("select * from expressage")
    List<dingDan> dingdan(String did,String sNumber,Integer id);

    @Insert("insert into expressage(e_id,d_id, j_address, j_city,s_city,s_detail_city,s_name,s_number,j_time, " +
            "j_phnumber,j_name,w_name, f_type,j_infrom,status,number,weight,d_type,s_id)" +
            " values(#{eId},#{dId},#{jAddress},#{jCity},#{sCity},#{sDetailcity},#{sName}," +
            "#{sNumber},#{jTime},#{jPhnumber},#{jName},#{wName},#{fType},#{jInfrom},#{sTatus}" +
            ",#{nUmber},#{weight},#{dType},#{sId})")
    Boolean inserding(dingDan dan);

    //用户根据订单号查询订单信息
    @Select("select * from expressage where d_id=#{dId}")
    List<dingDan> serchbyid(String dId);

    //显示待审核
    @Select("select * from expressage where d_type=5")
    List<dingDan> check();
    //显示待揽收
    @Select("select * from expressage where d_type=#{dtype} and k_id=#{kId}")
    List<dingDan> serchbytype(Integer dtype,Integer kId);

    //显示待派送
    @Select("select * from expressage where d_type=#{dtype} and k_id=#{kId}")
    List<dingDan> serchbytype1(Integer dtype,Integer kId);



    //揽收
    @Update("update expressage SET d_type=3,k_id=#{kId} where e_id=#{eid}")
    void lanshou(Integer eid,Integer kId);

    //派送
    @Update("update expressage SET d_type=4 where e_id=#{eid}")
    void paisong(Integer eid);


    //重新派单 状态码8表示待接单
    @Update("update expressage SET d_type=8 where e_id=#{eid}")
    void rpaidan(Integer eid);

    //审核通过
    @Update("update expressage SET d_type=1 where e_id=#{eid}")
    void pass(Integer eid);

    //填写原因
    @Update("update expressage SET d_type=7,reasion=#{reasion} where e_id=#{eid}")
    void nopass(Integer eid,String reasion);


    //禁用
    @Update("update yonghu SET type=0 where znumber=#{znumber}")
    void ban(String znumber);
    //数据饼图

    @MapKey("name")
    List<Map<Object, Object>> shuju();

    //订单总数
    @Select("SELECT COUNT(*)AS expersess FROM expressage")
    List<Integer> totalExpre();
    //管理员总数
    @Select("SELECT COUNT(*)AS  gnumber FROM yonghu WHERE rejuster=1")
    List<Integer> totalGuser();
    //快递员总数
    @Select("SELECT COUNT(*)AS knumber FROM yonghu WHERE rejuster=2")
    List<Integer> totalKuser();
    // 用户总数
    @Select("SELECT COUNT(*)AS usernumber FROM USER")
    List<Integer> totalUser();

}
