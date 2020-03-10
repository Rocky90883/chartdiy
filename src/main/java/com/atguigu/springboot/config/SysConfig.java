package com.atguigu.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;

public class SysConfig {

//    private static SysConfigService service;

    /**
     * 通过key获取配置项值
     * @param key
     * @return
     */
    public static String getValue(String key){
        return "123";
    }

    /**
     * 通过key获取配置项值，当值为空时，采用默认值defaultValue
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getValue(String key, String defaultValue){
        String value = getValue(key);
        if(null == value){
            return defaultValue;
        }
        return value;
    }


//    @Autowired
//    public void setService(SysConfigService service) {
//        SysConfig.service = service;
//    }

}
