package com.atguigu.springboot.my.bean;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class YAxisBean {

    /**
     * y轴名字
     */
    private String yname;

    /**
     * 与series的yAxisIndex要对应才能匹配成功
     */
    private Integer yindex;

    /**
     * 本Y轴显示在左侧 还是 右侧  left,right
     */
    private String position;

    /**
     * y轴单位
     */
    private String axisLabel;

    /**
     *是否显示图表y轴的网格
     */
    private Boolean splitLine;

    /**
     *是否用颜色区分y轴隔区域
     */
    private Boolean splitArea;

    /**
     * y轴类型
     * 'value' 数值轴
     * 'category' 类目轴，适用于离散的类目数据，为该类型时必须通过 data 设置类目数据
     * 'time' 时间轴，适用于连续的时序数据，与数值轴相比时间轴带有时间的格式化，在刻度计算上也有所不同，例如会根据跨度的范围来决定使用月，星期，日还是小时范围的刻度。
     * 'log' 对数轴。适用于对数数据。
     */
    private String yType;

    /**
     * y轴数据
     */
    private Array ydata;

    /**
     *如果存在多个y轴设置 y轴与y轴之间的距离
     */
    private Integer offset;

//    private String position
//    private String position
}
