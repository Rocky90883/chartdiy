package com.atguigu.springboot.my.bean;

import com.atguigu.springboot.utils.CommonUtil;
import com.atguigu.springboot.utils.JacksonUtil;
import lombok.Data;

@Data
public class MessageBean<T> {
    /**
     * 信息代码
     */
    private int code;
    /**
     * 信息编码
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public String tojson(){
       return CommonUtil.toJson(this);
    }
}