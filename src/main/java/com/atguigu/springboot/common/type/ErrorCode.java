package com.atguigu.springboot.common.type;

public enum ErrorCode {

    SUCCESS(0, "成功"),

    FAIL(-1, "失败"),

    NOT_LOGIN(10000, "未登录"),

    NO_PERMISSION(10001, "无操作权限"),

    NO_USER(10002, "用户不存在"),

    PARAM_INVALID(20001, "参数校验不通过"),

    UNKNOWN_ERROR(40000, "未知错误"),

    INTERVAL_ERROR(40001, "程序内部异常");

    private Integer code;
    private String name;

    private ErrorCode(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
