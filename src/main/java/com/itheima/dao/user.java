package com.itheima.dao;

import com.itheima.domin.User;
import com.itheima.domin.dingDan;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface user {
    @Select("select * from user where username=#{name} and password=#{password}")
    User ulogin(String name, String password);

    @Select("select * from user where username=#{username}")
    User searchall(String username);

    Boolean update(User user);

    List<dingDan> history(String did, String sNumber,Integer sId);

    @Select("SELECT expressage.*,yonghu.`yname`,yonghu.`tphnumber`FROM expressage JOIN yonghu ON expressage.`k_id`=yonghu.`id` WHERE (expressage.d_type BETWEEN 1 AND 5) AND expressage.s_id=#{sId} ORDER BY e_id DESC")
    List<dingDan> mydan(Integer sId);

    @Select("SELECT * FROM expressage WHERE d_type=5 and s_id=#{sId} ORDER BY e_id desc")
    List<dingDan> wack(Integer sId);

    @Select("SELECT * FROM expressage WHERE d_type=8 and s_id=#{sId} ORDER BY e_id desc")
    List<dingDan> ware(Integer sId);

    @Select("SELECT * FROM expressage WHERE d_type=7 and s_id=#{sId} ORDER BY e_id desc")
    List<dingDan> faile(Integer sId);

    @MapKey("name")
    List<Map<Object, Object>> shuju(Integer id);


}
