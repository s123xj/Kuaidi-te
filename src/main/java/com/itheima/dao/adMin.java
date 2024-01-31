package com.itheima.dao;

import com.itheima.domin.KUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface adMin {
    //新增员工
    @Insert("insert into yonghu(znumber,yname,tphnumber,rejuster,type,passward)" +
            " values(#{znumber},#{yname},#{tphnumber},#{rejuster},#{type},#{passward})")
    Boolean addinform(KUser kUser);
}
