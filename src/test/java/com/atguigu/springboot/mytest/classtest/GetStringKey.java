package com.atguigu.springboot.mytest.classtest;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class GetStringKey {

    /**
     * 生成16位key
     *
     * @return
     */
    @Test
    public void get16Key() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        char s;
        String key = "";
        Random ran = new Random();
        for (int i = 0; i < 16; i++) {
            int index = ran.nextInt(32);
            char[] chars = uuid.toCharArray();
            s = chars[index];
            key += s;
        }
        System.out.println(key.toUpperCase());
        return;
    }





}
