package com.atguigu.springboot.bean.hualala.vo;

import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import com.atguigu.springboot.target.Description;
import lombok.Data;

@Data
public class HualalaVo {

    @Description(zh_Name = "哗啦啦标识" ,sort = 0)
    private String id;

    @Description(zh_Name = "订单日期" ,sort = 8)
    private String reportDate;

    @Description(zh_Name = "门店标识" ,sort = 1)
    private String shopID;

    @Description(zh_Name = "门店名字" ,sort = 2)
    private String shopName;

    @Description(zh_Name = "订单状态" ,sort = 3)
    private String orderStatus;

    @Description(zh_Name = "订单标识" ,sort = 4)
    private String saasOrderKey;

    @Description(zh_Name = "菜品数目" ,sort = 5)
    private Double foodCount;

    @Description(zh_Name = "订单总额" ,sort = 6)
    private Double foodAmount;

    @Description(zh_Name = "发生时间" ,sort = 7)
    private String actionTime;

    public HualalaVo(){

    }

    public HualalaVo(BdhualalaBean bean){
        this.id = bean.getId();
        this.reportDate = bean.getReportDate();
        this.shopID =  bean.getShopID();
        this.shopName = bean.getShopName();
        this.orderStatus = bean.getOrderStatus();
        this.saasOrderKey = bean.getSaasOrderKey();
        this.foodCount = bean.getFoodCount();
        this.foodAmount = bean.getFoodAmount();
        this.actionTime = bean.getActionTime();
    }

}
