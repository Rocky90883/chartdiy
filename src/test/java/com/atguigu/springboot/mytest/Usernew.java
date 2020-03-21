package com.atguigu.springboot.mytest;

import java.util.List;

public class Usernew {

    private Integer id;

    private  String name;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usernew(Integer id) {
        this.id = id;
    }
}
