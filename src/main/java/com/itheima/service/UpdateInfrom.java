package com.itheima.service;


import com.itheima.domin.KUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UpdateInfrom {
    KUser serbynumber(String znubmber);

    Boolean update(KUser kUser);

    Boolean chongzhi(String passward,String znumber );

}
