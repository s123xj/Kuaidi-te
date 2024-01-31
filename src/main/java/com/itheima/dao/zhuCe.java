package com.itheima.dao;

import com.itheima.domin.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface zhuCe {
    @Insert("insert into user(id,username,password,register_time ) values(#{id},#{username}," +
            "#{password},#{registerTime})" )
    Boolean zhuce(User user);
}
