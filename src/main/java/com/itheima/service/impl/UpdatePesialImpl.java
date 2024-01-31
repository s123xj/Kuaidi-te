package com.itheima.service.impl;

import com.itheima.dao.user;
import com.itheima.domin.User;
import com.itheima.service.UpdatePesial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatePesialImpl implements UpdatePesial {
    @Autowired
    private user u;
    @Override
    public Boolean update(User user) {
       return u.update(user);
    }
}
