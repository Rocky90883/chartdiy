package com.atguigu.springboot.mapper.primary;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.bean.SharePo;

import java.util.List;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface ShareMapper {

    public List<SharePo> selectList();

    public Employee getEmpByShareid(String shareid);

    public void insertShare(SharePo sharePo);

    public void updateShart(SharePo sharePo);


}
