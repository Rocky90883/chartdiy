package com.atguigu.springboot.mapper.primary;

import com.atguigu.springboot.my.vo.WeightVo;

import java.util.List;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface WeightMapper {

//    public List<SharePo> selectList();

    public List<WeightVo> getWeightByList();

//    public void insertShare(SharePo sharePo);
//
//    public void updateShart(SharePo sharePo);


}
