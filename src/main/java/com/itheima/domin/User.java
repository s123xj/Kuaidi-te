package com.itheima.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private LocalDateTime registerTime;
    private String phnumber;
    private String detailaddress;//详细地址不包含省市区
    private String address;//总地址
    private String addrescity;//省市区
    private List<Object> city;



}