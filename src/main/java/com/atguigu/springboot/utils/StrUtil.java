package com.atguigu.springboot.utils;

public class StrUtil {

    public static String replacetoSQLinStr(String str,String oldChar,String newChar){
        return "'"+str.replace(oldChar,newChar)+"'";
    }

}
