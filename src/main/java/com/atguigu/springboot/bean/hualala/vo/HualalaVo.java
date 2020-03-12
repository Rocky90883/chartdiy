package com.atguigu.springboot.bean.hualala.vo;

import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import lombok.Data;

@Data
public class HualalaVo {

    private String reportDate;
    private String shopID;
    private String shopName;
    private String orderStatus;
    private String saasOrderKey;
    private Double foodCount;
    private Double foodAmount;
    private String actionTime;

    public HualalaVo(){

    }

    public HualalaVo(BdhualalaBean bean){
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
