package com.atguigu.springboot.bean;

import com.atguigu.springboot.type.enums.OrderInfoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor  //添加无参构造方法
@AllArgsConstructor //添加全参构方法
@Accessors(chain = true)  //添加链式调用
public class OrderInfo {

    private Integer id;

    private OrderInfoEnum status;

}
