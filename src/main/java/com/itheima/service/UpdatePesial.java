package com.itheima.service;

import com.itheima.domin.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UpdatePesial {
    Boolean update(User user);
}
