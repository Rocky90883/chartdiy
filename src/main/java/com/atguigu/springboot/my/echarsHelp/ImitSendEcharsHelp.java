package com.atguigu.springboot.my.echarsHelp;

import com.atguigu.springboot.my.bean.SeriesBean;
import com.atguigu.springboot.my.bean.XAxisBean;
import com.atguigu.springboot.my.bean.YAxisBean;
import com.atguigu.springboot.my.dto.InitEcharsDto;
import com.atguigu.springboot.utils.ImitationDataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImitSendEcharsHelp {

    public InitEcharsDto InitEcharsData(){

        ImitationDataUtil imitData = new ImitationDataUtil();
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
        legendDataNamelist.add("百香果量");
//        legendDataNamelist.add("百香果百分比");
//        legendDataNamelist.add("百香果百分比2");
        initDto.setLegendDataNamelist(legendDataNamelist);
        initDto.setDataZoomFlag(true);

        List<XAxisBean> xlist = new ArrayList();
        List<YAxisBean> ylist = new ArrayList<>();
        XAxisBean xBean = new XAxisBean();
        YAxisBean yBean1 = new YAxisBean();
        YAxisBean yBean2 = new YAxisBean();
        YAxisBean yBean3 = new YAxisBean();
        YAxisBean yBean4 = new YAxisBean();
        YAxisBean yBean5 = new YAxisBean();
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

        yBean3.setYname("百香果量");
        yBean3.setYType("value");
        yBean3.setYindex(2);
        yBean3.setPosition("left");
        yBean3.setAxisLabel("个");
        yBean3.setSplitArea(false);
        yBean3.setSplitLine(true);
        yBean3.setOffset(70);

        yBean4.setYname("百香果百分比");
        yBean4.setYType("value");
        yBean4.setYindex(3);
        yBean4.setPosition("right");
        yBean4.setAxisLabel("%");
        yBean4.setSplitArea(false);
        yBean4.setSplitLine(true);
        yBean4.setOffset(70);

        yBean5.setYname("百香果百分比2");
        yBean5.setYType("value");
        yBean5.setYindex(4);
        yBean5.setPosition("left");
        yBean5.setAxisLabel("%");
        yBean5.setSplitArea(false);
        yBean5.setSplitLine(true);
        yBean5.setOffset(70);

        ylist.add(yBean1);
        ylist.add(yBean2);
        ylist.add(yBean3);
//        ylist.add(yBean4);
//        ylist.add(yBean5);

        initDto.setYAxisList(ylist);

        List<SeriesBean> seriesList = new ArrayList<>();
        SeriesBean sBean1 = new SeriesBean();
        SeriesBean sBean2 = new SeriesBean();
        SeriesBean sBean3 = new SeriesBean();
        SeriesBean sBean4 = new SeriesBean();
        SeriesBean sBean5 = new SeriesBean();
        SeriesBean sBean6 = new SeriesBean();
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

        sBean3.setDataName("百香果量");
        sBean3.setSeriestype("line");
        sBean3.setMarkLineflag(true);
        sBean3.setMarkPointflag(true);
        sBean3.setYAxisIndex(2);
        List<String> rosebxgDate = imitData.RandomData(5000,6000,1,"");
        sBean3.setData(rosebxgDate);

        sBean4.setDataName("百香果百分比");
        sBean4.setSeriestype("line");
        sBean4.setMarkLineflag(true);
        sBean4.setMarkPointflag(true);
        sBean4.setYAxisIndex(3);
        List<String> rosePercentbxgDate = imitData.RandomData(5000,3000,1,"");
        sBean4.setData(rosePercentDate);

        sBean5.setDataName("百香果百分比2");
        sBean5.setSeriestype("line");
        sBean5.setMarkLineflag(true);
        sBean5.setMarkPointflag(true);
        sBean5.setYAxisIndex(4);
        List<String> rosePercentbxgDate2 = imitData.RandomData(5000,3000,1,"");
        sBean5.setData(rosePercentDate);

        seriesList.add(sBean1);
        seriesList.add(sBean2);
        seriesList.add(sBean3);
//        seriesList.add(sBean4);
//        seriesList.add(sBean5);

        initDto.setSeriesList(seriesList);
        return initDto;
    }

    public InitEcharsDto InitEcharsPieData(){
        ImitationDataUtil imitData = new ImitationDataUtil();
        InitEcharsDto initDto = new InitEcharsDto();
        initDto.setText("百分比姓名饼图");
        initDto.setDataViewFlag(true);
        List<SeriesBean> seriesList = new ArrayList<>();
        SeriesBean sBean1 = new SeriesBean();
        sBean1.setSeriestype("pie");
        sBean1.setDataName("姓名");
        List<Map<String,Object>> roseDate = imitData.RandomDataKeyValue(41,400,200);
        sBean1.setPiedate(roseDate);
        seriesList.add(sBean1);
        initDto.setSeriesList(seriesList);
        return initDto;
    }

}
