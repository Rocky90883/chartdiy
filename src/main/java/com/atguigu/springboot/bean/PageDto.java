package com.atguigu.springboot.bean;

import lombok.Data;

@Data
public class PageDto {
    private Integer begin;
    private Integer size;
    private String sortField; //排序字段
    private String sortType; // desc asc
}

