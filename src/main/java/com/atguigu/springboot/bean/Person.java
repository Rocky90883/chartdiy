package com.atguigu.springboot.bean;

import com.atguigu.springboot.my.bean.Weight;

import java.util.List;

public class Person {

    private Integer id;
    private String username;
    private String password;
    private List<Weight> weights;

    public Person() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Weight> getWeights() {
        return weights;
    }

    public void setWeights(List<Weight> weights) {
        this.weights = weights;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", username=" + username + ", weights=" + weights + "]";
    }
}
