package com.atguigu.springboot.mytest.Bean;

public class Employee {

    private String name;

    private int aget;

    private double money;

    public Employee(String name, int aget, double money) {
        this.name = name;
        this.aget = aget;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", aget=" + aget +
                ", money=" + money +
                '}';
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
}
