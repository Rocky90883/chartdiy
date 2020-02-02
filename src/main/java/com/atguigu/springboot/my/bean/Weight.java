package com.atguigu.springboot.my.bean;

public class Weight {
    private Integer id;
    private double weight;
    private String wdate;
    private String info;

    public Weight() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Weight [id=" + id + ", weight=" + weight + ", wdate=" + wdate + ", info=" + info + "]";
    }
}