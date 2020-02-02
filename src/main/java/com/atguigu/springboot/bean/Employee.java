package com.atguigu.springboot.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class Employee {

    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户名")
    private String lastName;

    @ApiModelProperty("用户性别 1：男 2：女")
    private Integer gender;

    @ApiModelProperty("用户email")
    private String email;

    private Integer dId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Integer getdId() {
        return dId;
    }
}
