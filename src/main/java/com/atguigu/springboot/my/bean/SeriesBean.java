package com.atguigu.springboot.my.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SeriesBean {

    /**
     * 数据名称
     */
    private String dataName;

    /**
     *折线图line   柱状图bar  pie饼图
     */
    private String seriestype;

    /**
     * 数据
     */
    private List<String> data;

    /**
     * 是否需要图表自动标记出最大最小值
     */
    private Boolean markPointflag;

    /**
     * 是否需要图表显示平均值
     */
    private Boolean markLineflag;

    /**
     * 指定第几个y轴 默认是是零
     */
    private Integer yAxisIndex;

    /**
     * 饼图的中心（圆心）坐标，数组的第一项是横坐标，第二项是纵坐标 center: ['40%', '50%']
     */
    private List<String> pieCenter;

    /**
     * 饼图数组的第一项是内半径，第二项是外半径。每一项遵从上述 number string 的描述。[ default: ['0', '75%'] ]
     */
    private List<String> radius;

    /**
     * 饼图数据只能是 key，value
     */
    private List<Map<String,Object>> piedate;
}
