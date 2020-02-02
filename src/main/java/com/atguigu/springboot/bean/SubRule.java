package com.atguigu.springboot.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubRule {
    private String id;
    private String name;
    private Object detail;             //json类型
    private String ruleId;
    private int dimensionSize;

}
