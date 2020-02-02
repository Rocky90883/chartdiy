package com.atguigu.springboot.my.Env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rocky
 */
public class BaseEnv {

//    public Object o ;
//
//    public BaseEnv(Object o){
//        this.o=o;
//    }

//    public static Logger log = LoggerFactory.getLogger(getClass());

    public  Object errheadmsg = "类名为："+this.getClass().toString()+"中 方法为："+Thread.currentThread() .getStackTrace()[1].getMethodName().toString()+"的报错信息：";

}
