package com.atguigu.springboot.my.controller;


import com.atguigu.springboot.mapper.primary.WeightMapper;
import com.atguigu.springboot.my.bean.MessageBean;
import com.atguigu.springboot.my.bean.SeriesBean;
import com.atguigu.springboot.my.bean.XAxisBean;
import com.atguigu.springboot.my.bean.YAxisBean;
import com.atguigu.springboot.my.dto.InitEcharsDto;
import com.atguigu.springboot.my.echarsHelp.ImitSendEcharsHelp;
import com.atguigu.springboot.my.vo.PaageVo;
import com.atguigu.springboot.my.vo.WeightVo;
import com.atguigu.springboot.utils.ImitationDataUtil;
import com.atguigu.springboot.utils.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class VotingController {

    Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    WeightMapper weightMapper;

    @RequestMapping(value = "/voting")
    public ModelAndView voting(HashMap map) {
        logger.info("进入瀑布");
        logger.info("接受到数据："+map);


        ModelAndView mv = new ModelAndView("voting");
//        logger.info(map!=null?"最终json数据:"+map:"最终json数据:"+json);
//        mv.addObject("mb",json);
//        mv.addObject("initEcharsDto",initEcharsDto);
        return mv;
    }

    @RequestMapping(value = "/myindex")
    public ModelAndView myindex(HashMap map) {
        logger.info("进入瀑布");
        logger.info("接受到数据："+map);


        ModelAndView mv = new ModelAndView("bootstrapTheme/index");
//        logger.info(map!=null?"最终json数据:"+map:"最终json数据:"+json);
//        mv.addObject("mb",json);
//        mv.addObject("initEcharsDto",initEcharsDto);
        return mv;
    }

}
