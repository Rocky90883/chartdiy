package com.atguigu.springboot.mytest.Bean;

import java.math.BigDecimal;

public class Employee {

    private String name;

    private int aget;

    private double money;

    private BigDecimal number;

    private Integer index;

    public Employee(String name, int aget, double money,BigDecimal number) {
        this.name = name;
        this.aget = aget;
        this.money = money;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", aget=" + aget +
                ", money=" + money +
                ", number=" + number +
                ", index=" + index +
                '}';
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAget() {
        return aget;
    }

    public void setAget(int aget) {
        this.aget = aget;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
