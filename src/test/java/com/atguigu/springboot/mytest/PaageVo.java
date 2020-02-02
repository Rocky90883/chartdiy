package com.atguigu.springboot.mytest;

import java.util.List;

public class PaageVo<T> {
    private List<T> dataList;
    private Integer totalPage;
    private Integer rows;

    public PaageVo() {
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

