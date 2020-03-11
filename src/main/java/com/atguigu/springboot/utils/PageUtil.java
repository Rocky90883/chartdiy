package com.atguigu.springboot.utils;

public class PageUtil {

    /**
     * 获取mysql分页查询时的begin参数，代表从n条开始查（0代表第一条）
     *
     * @param pageNum 第几页
     * @param pageSize 每页最多几行
     * @return
     */
    public static int getBegin(int pageNum, int pageSize) {
        if (pageNum == 0) {
            pageNum = 1;
        }
        return (pageNum - 1) * pageSize;
    }

    /**
     * 获取总共分了多少页
     * @param rows
     * @param pageSize
     * @return
     */
    public static int getTotalPage(int rows, int pageSize) {
        return rows % pageSize == 0 ? rows / pageSize : rows / pageSize + 1;
    }
}
