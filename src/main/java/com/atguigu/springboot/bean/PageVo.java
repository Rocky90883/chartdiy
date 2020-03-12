package com.atguigu.springboot.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVo<T> {
    private List<T> dataList;
    private Integer totalPage;
    private Integer rows;
}
