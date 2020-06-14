package com.atguigu.springboot.my.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.primary.EmployeeMapper;
import com.atguigu.springboot.my.Env.BaseEnv;
import com.atguigu.springboot.my.bean.MessageBean;
import com.atguigu.springboot.utils.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedisTestController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping(value = "queryAllEmp",method = RequestMethod.GET)
    public String queryAllEmp(){

        List<Employee> emplist = employeeMapper.selectList();
        MessageBean mb = new MessageBean();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(emplist);
        String rs = "";
        log.info(new BaseEnv().errheadmsg.toString()+"数据类型转换错误");
        try {
            rs=JacksonUtil.toJson(mb);
        } catch (JsonProcessingException e) {
            log.info(new BaseEnv().errheadmsg.toString()+"数据类型转换错误");
            e.printStackTrace();
        }
        return rs;
    }

}
