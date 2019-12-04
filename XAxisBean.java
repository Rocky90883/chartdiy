package com.atguigu.springboot.my.bean;

import lombok.Data;

import java.util.List;

@Data
public class XAxisBean {

    /**
     * x轴单位
     */
    private String unitName;

    /**
     * x轴数据
     */
    private List<String> xdata;

    /**
     *是否显示图表纵轴的网格
     */
    private Boolean splitLine;

    /**
     *是否用颜色区分x轴隔区域
     */
    private Boolean splitArea;

    /**
     *可以设置成 0 强制显示所有标签。
     *如果设置为 1，表示『隔一个标签显示一个标签』，如果值为 2，表示隔两个标签显示一个标签，以此类推。
     * 可不传
     */
    private Integer interval;

    /**
     * 刻度标签旋转的角度，在类目轴的类目标签显示不下的时候可以通过旋转防止标签之间重叠。旋转的角度从 -90 度到 90 度。
     */
    private Integer rotate;







}
