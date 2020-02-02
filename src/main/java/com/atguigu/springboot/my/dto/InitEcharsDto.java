package com.atguigu.springboot.my.dto;

import com.atguigu.springboot.my.bean.SeriesBean;
import com.atguigu.springboot.my.bean.XAxisBean;
import com.atguigu.springboot.my.bean.YAxisBean;
import lombok.Data;

import java.util.List;

@Data
public class InitEcharsDto {

    /**
     * 图表名字
     */
    private String text;

    /**
     * 是否数据直接显示
     */
    private Boolean dataViewFlag;               //是否数据直接显示

    /**
     * 工具栏  区域选择 lineX  折线图 line   柱状图 bar  stack 堆叠模式  tiled 平铺模式
     */
    private List<String> magicTypelist;

    /**
     * 数据名字  数据选中显示，不选中不显示
     */
    private List<String> legendDataNamelist;    //数据名字  数据选中显示，不选中不显示

    /**
     * 图表放大 鼠标滚轮缩放
     */
    private Boolean dataZoomFlag;

    /**
     *x轴信息
     */
    private List<XAxisBean> xAxisList;

    /**
     *y轴信息
     */
    private List<YAxisBean> yAxisList;

    /**
     *Series轴信息
     */
    private List<SeriesBean> seriesList;
}
