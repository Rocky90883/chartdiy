package com.atguigu.springboot.bean;

import com.atguigu.springboot.enums.OrderInfoEnum;
import lombok.Data;

@Data
public class OrderInfo {

    private Integer id;

    private OrderInfoEnum status;

}
