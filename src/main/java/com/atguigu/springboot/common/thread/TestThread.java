package com.atguigu.springboot.common.thread;

public class TestThread implements Runnable{

    private String str;

    public TestThread(String str){
        this.str = str;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {

        System.out.println(str);

    }
}
