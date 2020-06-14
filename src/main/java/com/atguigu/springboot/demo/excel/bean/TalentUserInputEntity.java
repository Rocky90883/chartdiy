package com.atguigu.springboot.demo.excel.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ExcelTarget("talentUserInputEntity")
public class TalentUserInputEntity{

    @Excel(name = "姓名*")
    private String name;

    @Excel(name = "性别*")
    private String gender;

    @Excel(name = "手机号*")
    private String phone;

//    @Excel(name = "开始工作时间*")
//    private Date workTime;
//
//    @Excel(name = "民族*")
//    private String national;
//
//    @Excel(name = "语言水平*")
//    private String languageProficiency;
//
//    @Excel(name = "出生日期*")
//    private Date birth;
//
//    @Excel(name = "职位*")
//    private String jobsName;
//
//    @Excel(name = "职位类型*")
//    private String categoryName;
//
//    @Excel(name = "薪资*")
//    private Integer salary;
//
//    @Excel(name = "工作地点*")
//    private String workArea;

    @ExcelCollection(name = "工作经历*")
    private List<ExperienceInputEntity> experienceList;

//    @ExcelCollection(name = "教育经历*")
//    private List<EducationInputEntity> educationList;
//
//    @ExcelCollection(name = "获奖情况")
//    private List<AwardsInputEntity> awardList;
//
//    @ExcelCollection(name = "技能证书")
//    private List<PunishmentInputEntity> punishmentList;

//    @Excel(name = "特长")
//    private String specialty;


    public TalentUserInputEntity() {
    }

    public TalentUserInputEntity(String name, String gender, String phone, List<ExperienceInputEntity> experienceList) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.experienceList = experienceList;
    }
}
