package com.atguigu.springboot.mapper.hualala;

import com.atguigu.springboot.bean.OrderInfo;
import com.atguigu.springboot.bean.hualala.Bdhualala;
import com.atguigu.springboot.type.enums.OrderInfoEnum;

import java.util.List;

public interface BdhualalaMapper {

    public Bdhualala selectByPrimaryKey(String id);

    public List<Bdhualala> selectByOrderSubType(Bdhualala bdhualala);

}
