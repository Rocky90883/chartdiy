package com.atguigu.springboot.bean.hualala;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Bdhualala {

    private String id;
    private String  shopID;
    private String  saasOrderKey;
    private String  shopName;
    private String  orderStatus;
    private String  foodCount;
    private String  foodAmount;
    private String  startTime;
    private String  createTime;
    private String  actionTime;
    private String  areaName;
    private String  reportDate;


}
