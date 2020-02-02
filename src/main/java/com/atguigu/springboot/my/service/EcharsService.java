//package com.atguigu.springboot.my.service;
//
//import com.atguigu.springboot.my.bean.MessageBean;
//import com.atguigu.springboot.my.dto.InitEcharsDto;
//import com.atguigu.springboot.my.echarsHelp.ImitSendEcharsHelp;
//import com.atguigu.springboot.utils.ImitationDataUtil;
//import com.atguigu.springboot.utils.JacksonUtil;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//@Service
//public class EcharsService {
//
//    @RequestMapping("/landing")
//    public ModelAndView landingHandler(@RequestParam String json, HttpServletRequest request){
//
//        Logger logger = LoggerFactory.getLogger(getClass());
//
//        ImitationDataUtil imitData = new ImitationDataUtil();
//
//        ImitSendEcharsHelp imitEHelp = new ImitSendEcharsHelp();
//
//        MessageBean mb = new MessageBean();
//        InitEcharsDto initEcharsDto = imitEHelp.InitEcharsData();
//        mb.setCode(0);
//        mb.setMessage("成功");
//        mb.setData(initEcharsDto);
//        json = "";
//        try{
//            json = JacksonUtil.toJson(mb);
//        }catch (JsonProcessingException e){
//            logger.error("myEchartstwo()对象转json异常");
//            e.printStackTrace();
//        }
//
//        ModelAndView mv = new ModelAndView("DataEcharts");
//        mv.addObject("mb",json);
//        return mv;
//
//    }
//}
