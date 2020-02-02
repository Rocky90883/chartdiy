package com.atguigu.springboot.my.bean;

import lombok.Data;

@Data
public class MessageBean {
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
    private Object data;


//    public MessageBean() {
//        super();
//    }
//
//    public MessageBean(int code, String message, Object data) {
//        super();
//        this.code = code;
//        this.message = message;
//        this.data = data;
//    }
//
//    public int getCode() {
//        return code;
//    }
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//    public void setMessage(String message) {
//        this.message = message;
//    }

}