package com.itheima.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dingDan {
    private Integer eId;  //  编号
    private String dId;  //  订单号
    private String jAddress;  //  寄件地址
    private String jCity;  //  寄件城市 省市区
    private String sCity;  //  收件城市 省市区
    private List<Object> jc;
    private List<Object> sc;
    private String sDetailcity;  //  收件人地址
    private String sName ;  //  收件人姓名
    private String sNumber;  //  收件人电话
    private LocalDateTime jTime;  //  下单时间
    private String jPhnumber;  //  寄件人电话
    private String jName;  //  寄件人姓名
    private String wName;  //  物品名称
    private int fType;  //  付款方式
    private String jInfrom;  //  备注
    private int sTatus;  //  寄件方式
    private int nUmber;  //  件数最大20
    private String weight;  //  物品数量
    private int dType; //订单状态
    private int sId;//订单所属用户
    private String reasion; //审核不通过原因
    private Integer kId;//快递员编号
    private String yname;//快递员姓名
    private String tphnumber;//快递员电话


}
