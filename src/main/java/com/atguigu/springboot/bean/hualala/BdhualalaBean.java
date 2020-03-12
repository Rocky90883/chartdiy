package com.atguigu.springboot.bean.hualala;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BdhualalaBean {

    private String PUID;
    private String id;
    private String shopID;
    private String saasOrderKey;
    private String saasDeviceOrderNo;
    private String shopName;
    private String orderSubType;
    private String netOrderTypeCode;
    private String createBy;
    private String checkoutBy;
    private String orderStatus;
    private String isTestOrder;
    private String orderMD5;
    private Double foodCount;
    private Double foodAmount;
    private Double sendFoodAmount;
    private Double sendCouponAmount;
    private String cardNo;
    private String discountBy;
    private Double discountRate;
    private String isVipPrice;
    private String moneyWipeZeroType;
    private Double specialStatAmount;
    private Double promotionAmount;
    private Double paidAmount;
    private String invoiceBy;
    private String invoiceTitle;
    private String invoiceTaxpayerIdentCode;
    private Double invoiceAmount;
    private Double invoiceTaxRate;
    private Double invoiceTaxAmount;
    private Double YJZCount;
    private Double FJZCount;
    private String deviceCode;
    private String reviewBy;
    private String reviewTime;
    private Double discountRange;
    private String startTime;
    private String checkoutTime;
    private String createTime;
    private String uploadTime;
    private String actionTime;
    private String areaName;
    private String reportDate;
    private Double person;


}
