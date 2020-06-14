package com.atguigu.springboot.demo.excel.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

// 教育经历对象
@Data
public class EducationInputEntity {
    @Excel(name = "学校*")
    private String schoolName;

    @Excel(name = "学历*")
    private Integer record;

    @Excel(name = "开始年份*")
    private Date beginTime;

    @Excel(name = "毕业年份*")
    private Date finishTime;

    @Excel(name = "专业*")
    private String profession;
}