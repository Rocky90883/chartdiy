package com.atguigu.springboot.mapper.hualala;

import com.atguigu.springboot.bean.OrderInfo;
import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import com.atguigu.springboot.bean.hualala.dto.BdhualalaDto;
import com.atguigu.springboot.type.enums.OrderInfoEnum;

import java.util.List;

public interface BdhualalaMapper {

    public BdhualalaBean selectByPrimaryKey(String id);

    public List<BdhualalaBean> selectByOrderSubType(BdhualalaDto bdhualalaDto);

    public Integer countselectByOrderSubType(BdhualalaDto bdhualalaDto);      //总行数

}
