package com.atguigu.springboot.bean.hualala.dto;

import com.atguigu.springboot.bean.PageDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BdhualalaDto extends PageDto{

    private String shopName;
    private String areaName;
    private String maxreportDate;
    private String minreportDate;
    private String shopID;
    private String orderStatus;

}
