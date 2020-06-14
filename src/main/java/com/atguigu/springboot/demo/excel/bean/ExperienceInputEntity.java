package com.atguigu.springboot.demo.excel.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

// 工作经历对象
@Data
@ExcelTarget("talentUserInputEntity")
public class ExperienceInputEntity {
    @Excel(name = "公司名称*")
    private String companyName;

    @Excel(name = "所在行业*")
    private String industry;

//    @Excel(name = "开始时间*")
//    private Date beginTime;
//
//    @Excel(name = "结束时间*")
//    private Date finishTime;
//
//    @Excel(name = "职位名称*")
//    private String jobTitle;
//
//    @Excel(name = "所属部门*")
//    private String department;
//
//    @Excel(name = "工作内容*")
//    private String description;


    public ExperienceInputEntity() {

    }

    public ExperienceInputEntity(String companyName, String industry) {
        this.companyName = companyName;
        this.industry = industry;
    }
}