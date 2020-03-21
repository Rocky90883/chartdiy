package com.atguigu.springboot.mytest;

import java.util.List;

public class User {

    private  String name;

    private  Integer old;

    private List<Kemu> kemulist;

    public List<Kemu> getKemulist() {
        return kemulist;
    }

    public void setKemulist(List<Kemu> kemulist) {
        this.kemulist = kemulist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private  String address;

}
