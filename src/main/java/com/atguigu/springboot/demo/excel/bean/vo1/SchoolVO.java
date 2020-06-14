package com.atguigu.springboot.demo.excel.bean.vo1;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 学校模型
 */
public class SchoolVO {

    /** 学校名称 */
    @Excel(name = "学校名称", orderNum = "6", width = 20)
    private String schoolName;

    /** 学校地址 */
    @Excel(name = "学校地址", orderNum = "8", width = 20)
    private String schoolAddress;


}
