package com.atguigu.springboot.bean;

public class SharePo {

    private String shareid;
    private String companyname;
    private String companyshort;
    private String sharecode;
    private String sharename;
    private Double todaybeginprice;
    private Double yesterdaycloseprice;
    private Double nowprice;
    private Double highprice;
    private Double lowprice;

    public void setShareid(String shareid) {
        this.shareid = shareid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setCompanyshort(String companyshort) {
        this.companyshort = companyshort;
    }

    public void setSharecode(String sharecode) {
        this.sharecode = sharecode;
    }

    public void setSharename(String sharename) {
        this.sharename = sharename;
    }

    public void setTodaybeginprice(Double todaybeginprice) {
        this.todaybeginprice = todaybeginprice;
    }

    public void setYesterdaycloseprice(Double yesterdaycloseprice) {
        this.yesterdaycloseprice = yesterdaycloseprice;
    }

    public void setNowprice(Double nowprice) {
        this.nowprice = nowprice;
    }

    public void setHighprice(Double highprice) {
        this.highprice = highprice;
    }

    public void setLowprice(Double lowprice) {
        this.lowprice = lowprice;
    }

    public String getShareid() {

        return shareid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCompanyshort() {
        return companyshort;
    }

    public String getSharecode() {
        return sharecode;
    }

    public String getSharename() {
        return sharename;
    }

    public Double getTodaybeginprice() {
        return todaybeginprice;
    }

    public Double getYesterdaycloseprice() {
        return yesterdaycloseprice;
    }

    public Double getNowprice() {
        return nowprice;
    }

    public Double getHighprice() {
        return highprice;
    }

    public Double getLowprice() {
        return lowprice;
    }




}
