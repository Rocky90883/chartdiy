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
import io.swagger.annotations.Api;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ec")
@Api(value="es",description="图表控制层")
public class EchartsController {

    Logger logger = LoggerFactory.getLogger(getClass());

    ImitationDataUtil imitData = new ImitationDataUtil();

    ImitSendEcharsHelp imitEHelp = new ImitSendEcharsHelp();

    @Autowired
    WeightMapper weightMapper;

//    @Autowired
//    ResultDto resultDto;

    @GetMapping("/wei")
    public ModelAndView myEcharts(Model model) {
//        System.out.println(id);
        List<WeightVo> weightVo = weightMapper.getWeightByList();
        System.out.println(weightVo);
        for (WeightVo wei: weightVo) {
            System.out.println(wei.getUsername());
        }
        PaageVo<WeightVo> pv = new PaageVo<>();
        pv.setDataList(weightVo);
        pv.setTotalPage(100);
        pv.setRows(1);
        List list = new ArrayList();
        JSONArray jsonObject4 = JSONArray.fromObject(weightVo);
        MessageBean mb = new MessageBean();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(pv);
        model.addAttribute("name", "hello");
        ModelAndView mv = new ModelAndView("DataEcharts");
        mv.addObject("mb",mb);
        return mv;
    }

    @PostMapping("/initEchars")
    public MessageBean initEchars() {

        List<String> dateList = imitData.loopDateaddOne(100,"20190101","yyyyMMdd");
        InitEcharsDto initDto = new InitEcharsDto();
        initDto.setText("玫瑰图表");
        initDto.setDataViewFlag(true);
        List<String> magicTypelist = new ArrayList<>();
        magicTypelist.add("lineX");
        magicTypelist.add("line");
        magicTypelist.add("bar");
        initDto.setMagicTypelist(magicTypelist);
        List<String> legendDataNamelist = new ArrayList<>();
        legendDataNamelist.add("玫瑰降量");
        legendDataNamelist.add("玫瑰百分比");
        initDto.setLegendDataNamelist(legendDataNamelist);
        initDto.setDataZoomFlag(true);
        List<XAxisBean> xlist = new ArrayList();
        List<YAxisBean> ylist = new ArrayList<>();
        XAxisBean xBean = new XAxisBean();
        YAxisBean yBean1 = new YAxisBean();
        YAxisBean yBean2 = new YAxisBean();
        xBean.setUnitName("日期");        //x轴单位
        xBean.setXdata(dateList);         //x轴数据
        xBean.setSplitArea(false);       //x轴颜色区分
        xBean.setSplitLine(false);       //x轴网格
        xBean.setRotate(0);              //倾斜度
        xlist.add(xBean);
        initDto.setXAxisList(xlist);
        yBean1.setYname("玫瑰降量");
        yBean1.setYType("value");
        yBean1.setYindex(0);
        yBean1.setPosition("left");
        yBean1.setAxisLabel("朵");
        yBean1.setSplitArea(false);
        yBean1.setSplitLine(true);
        yBean1.setOffset(0);
//        yBean1.setYType("category");
//        yBean1.setYdata();
        yBean2.setYname("玫瑰百分比");
        yBean2.setYType("value");
        yBean2.setYindex(1);
        yBean2.setPosition("right");
        yBean2.setAxisLabel("%");
        yBean2.setSplitArea(false);
        yBean2.setSplitLine(true);
        yBean2.setOffset(0);
        ylist.add(yBean1);
        ylist.add(yBean2);
        initDto.setYAxisList(ylist);
        List<SeriesBean> seriesList = new ArrayList<>();
        SeriesBean sBean1 = new SeriesBean();
        SeriesBean sBean2 = new SeriesBean();
        sBean1.setDataName("玫瑰降量");
        sBean1.setSeriestype("line");
        sBean1.setMarkLineflag(true);
        sBean1.setMarkPointflag(true);
        sBean1.setYAxisIndex(0);
        List<String> roseDate = imitData.RandomData(5000,8000,1,"");
        sBean1.setData(roseDate);
        sBean2.setDataName("玫瑰百分比");
        sBean2.setSeriestype("line");
        sBean2.setMarkLineflag(true);
        sBean2.setMarkPointflag(true);
        sBean2.setYAxisIndex(1);
        List<String> rosePercentDate = imitData.RandomData(5000,5000,1,"");
        sBean2.setData(rosePercentDate);
        seriesList.add(sBean1);
        seriesList.add(sBean2);
        initDto.setSeriesList(seriesList);

//        XAxisBean xb1 = new XAxisBean();
//        XAxisBean xb2 = new XAxisBean();
//        xb1.setUnitName("xname1");
//        xb2.setUnitName("xname2");
//        xlist.add(xb1);
//        xlist.add(xb2);
//        initDto.setXAxisList(xlist);

        MessageBean mb = new MessageBean();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(initDto);
        return mb;
    }

    @PostMapping("/invincibleData")
    public MessageBean invincibleData() {
        MessageBean mb = new MessageBean();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(123);
        return mb;
    }

    @RequestMapping(value = "/myEchartstwo")
    public ModelAndView myEchartstwo(String str) {
//        ,method = RequestMethod.POST
//        @RequestBody List<Map<String,String>> mapList
//        for (Map<String,String> map :  mapList ) {
//            System.out.println(map);
//        }
        logger.info("进入自定义配置图表接口");
        MessageBean mb = new MessageBean();
        logger.info("接受到数据："+str);
        InitEcharsDto initEcharsDto = imitEHelp.InitEcharsData();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(initEcharsDto);
        String json = "";
        try{
            json = JacksonUtil.toJson(mb);
        }catch (JsonProcessingException e){
            logger.error("myEchartstwo()对象转json异常");
            e.printStackTrace();
        }
        try {
            MessageBean mbcopy = JacksonUtil.readValue(json,MessageBean.class);
            System.out.println(mbcopy.getCode());
            InitEcharsDto initEcharsDtoCopy = JacksonUtil.readValue(JacksonUtil.toJson(mbcopy.getData()),InitEcharsDto.class);
            System.out.println(initEcharsDtoCopy.getText());
//            LinkedHashMap linmap = (LinkedHashMap)mbcopy.getData();
        } catch (IOException e) {
            logger.error("myEchartstwo() json转MessageBean异常");
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("DataEcharts");
        logger.info(str!=null?"最终json数据:"+str:"最终json数据:"+json);
        mv.addObject("mb",str!=null?str:json);
        mv.addObject("initEcharsDto",initEcharsDto);
        return mv;
    }

    @RequestMapping(value = "/myEchartspie")
    public ModelAndView myEchartspie(String str) {
        logger.info("进入自定义配置图表接口");
        logger.info("接受到数据："+str);
        MessageBean mb = new MessageBean();
        InitEcharsDto initEcharsDto = imitEHelp.InitEcharsPieData();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(initEcharsDto);
        String json = "";
        try{
            json = JacksonUtil.toJson(mb);
        }catch (JsonProcessingException e){
            logger.error("myEchartstwo()对象转json异常");
            e.printStackTrace();
        }

//        try {
//            MessageBean mbcopy = JacksonUtil.readValue(json,MessageBean.class);
//            System.out.println(mbcopy.getCode());
//            InitEcharsDto initEcharsDtoCopy = JacksonUtil.readValue(JacksonUtil.toJson(mbcopy.getData()),InitEcharsDto.class);
//            System.out.println(initEcharsDtoCopy.getText());
////            LinkedHashMap linmap = (LinkedHashMap)mbcopy.getData();
//        } catch (IOException e) {
//            logger.error("myEchartstwo() json转MessageBean异常");
//            e.printStackTrace();
//        }

        ModelAndView mv = new ModelAndView("DataEcharts");
        logger.info(str!=null?"最终json数据:"+str:"最终json数据:"+json);
        mv.addObject("mb",str!=null?str:json);
        mv.addObject("initEcharsDto",initEcharsDto);
        return mv;
    }


    @RequestMapping(value = "/myEchartshash")
    public ModelAndView myEchartshash(HashMap map) {
        logger.info("进入自定义配置图表接口");
        logger.info("接受到数据："+map);
        MessageBean mb = new MessageBean();
        InitEcharsDto initEcharsDto = imitEHelp.InitEcharsPieData();
        mb.setCode(0);
        mb.setMessage("成功");
        mb.setData(initEcharsDto);
        String json = "";
        try{
            json = JacksonUtil.toJson(mb);
        }catch (JsonProcessingException e){
            logger.error("myEchartstwo()对象转json异常");
            e.printStackTrace();
        }

//        try {
//            MessageBean mbcopy = JacksonUtil.readValue(json,MessageBean.class);
//            System.out.println(mbcopy.getCode());
//            InitEcharsDto initEcharsDtoCopy = JacksonUtil.readValue(JacksonUtil.toJson(mbcopy.getData()),InitEcharsDto.class);
//            System.out.println(initEcharsDtoCopy.getText());
////            LinkedHashMap linmap = (LinkedHashMap)mbcopy.getData();
//        } catch (IOException e) {
//            logger.error("myEchartstwo() json转MessageBean异常");
//            e.printStackTrace();
//        }

        ModelAndView mv = new ModelAndView("DataEcharts");
        logger.info(map!=null?"最终json数据:"+map:"最终json数据:"+json);
        mv.addObject("mb",json);
        mv.addObject("initEcharsDto",initEcharsDto);
        return mv;
    }

}
