package com.itheima.dao;

import com.itheima.domin.Guser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface guser {
    @Select("select * from yonghu where tphnumber=#{tphnumber} and passward =#{passward }" +
            " and rejuster=1")
    Guser glogin(String tphnumber, String passward);
}
