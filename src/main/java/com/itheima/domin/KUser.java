package com.itheima.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KUser {
    private Integer id;
    private String znumber;
    private String yname;
    private String tphnumber;
    private Integer rejuster;//1管理员 2快递员
    private String passward;
    private int type; //1
}
