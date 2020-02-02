package com.atguigu.springboot.controller;

import com.atguigu.springboot.mapper.primary.WeightMapper;
import com.atguigu.springboot.mapper.primary.WeightMapper;
import com.atguigu.springboot.my.bean.XAxisBean;
import com.atguigu.springboot.my.dto.InitEcharsDto;
import com.atguigu.springboot.my.vo.WeightVo;
import com.atguigu.springboot.utils.ImitationDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    WeightMapper weightMapper;

    ImitationDataUtil imitData = new ImitationDataUtil();

    @GetMapping("/toPerson")
    public String toPerson(){
        return "person/person";
    }

    @RequestMapping("/myEcharts/{id}")
    public String myEcharts(@PathVariable(name = "id") String id) {
        System.out.println(id);
        List<WeightVo> weightVo = weightMapper.getWeightByList();
        System.out.println(weightVo);
        for (WeightVo wei: weightVo) {
            System.out.println(wei.getUsername());
        }
        return "DataEcharts";
    }

    @RequestMapping(value = "/initEchars")
    public String initEchars(Map<String,Object> map) throws ParseException{

        List<String> dateArray = imitData.loopDateaddOne(100,"20190101","yyyyMMdd");
//        System.out.println(dateArray);

        InitEcharsDto initDto = new InitEcharsDto();
        initDto.setText("我是test");
        List<XAxisBean> xlist = new ArrayList();
        XAxisBean xb1 = new XAxisBean();
        XAxisBean xb2 = new XAxisBean();
        xb1.setUnitName("xname1");
        xb2.setUnitName("xname2");
        xlist.add(xb1);
        xlist.add(xb2);
        initDto.setXAxisList(xlist);
        map.put("dateArray",dateArray);
        map.put("initDto",initDto);
        map.put("hello","hello你好");
        return "DataEcharts";
    }


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
