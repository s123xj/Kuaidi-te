package com.itheima.dao;

import com.itheima.domin.KUser;
import com.itheima.domin.dingDan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface kUser {

    @Select("select * from yonghu")
    List<KUser> K_USERS();

    @Delete("delete from yonghu where znumber=#{zname}")
    void deleteByid(String zname);

    @Select("select * from yonghu where znumber=#{znumber}")
    KUser serbynumber(String znumber);

    Boolean update(KUser kUser);

    @Select("select * from yonghu where znumber=#{znumber} and passward=#{passward} and \n" +
            "rejuster=2")
    KUser klogin(String znumber,String passward);

    @Update("update yonghu set passward=#{passward} where znumber=#{znumber}")
    Boolean chognzhi(String passward ,String znumber);

    @Select("select * from expressage where d_type=8")
    List<dingDan> getdan();

    @Update("update expressage set k_id=#{kuserid},d_type=2 where e_id=#{eid}")
    void receivedan(Integer eid, Integer kuserid);
}
