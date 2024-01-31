package com.itheima.service.impl;

import com.itheima.dao.kUser;
import com.itheima.domin.KUser;
import com.itheima.service.UpdateInfrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateInfromimpl implements UpdateInfrom {
    @Autowired
    private kUser kUser;


    @Override
    public KUser serbynumber(String znumber) {
        return kUser.serbynumber(znumber);
    }

    @Override
    public Boolean update(KUser kuser) {
        return kUser.update(kuser);
    }

    @Override
    public Boolean chongzhi(String passward,String znumber) {
        return kUser.chognzhi(passward,znumber);
    }

}
