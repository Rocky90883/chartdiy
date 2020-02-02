package com.atguigu.springboot.controller;

import com.atguigu.springboot.Helper.GetStockList;
import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.SharePo;
import com.atguigu.springboot.mapper.primary.ShareMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "USERINFO", description = "股票接口")
public class AguController {

    @Autowired
    ShareMapper shareMapper;


    @GetMapping("/pullAgu")
    @ApiOperation("爬取所有A股到数据库")
    public String dopull(){
        GetStockList getStockList = new GetStockList();
        //在线拉去所有A股
        List<SharePo>  newsharePolist = getStockList.dopull();
        //本地获取所有A股
        List<SharePo>  oldsharelist = shareMapper.selectList();
        if(newsharePolist.size()==0){
            return "没有获取到新的数据可能网站已更新或已搬迁";
        }
        //新旧List对比进行过滤
        Map<String,List<SharePo>> map = getStockList.sharePofilter(oldsharelist,newsharePolist);
        //插入新增股
        for(SharePo po :  map.get("insertsharePoslist")){
            shareMapper.insertShare(po);
        }
        //更新原有股 updateShart
        for(SharePo po :  map.get("updatesharePoslist")){
            shareMapper.updateShart(po);
        }
        return "爬取成功";
    }

    @GetMapping("/selectAllAgu")
    @ResponseBody
    public List<SharePo> getDepartment(){
        return shareMapper.selectList();
    }

}
