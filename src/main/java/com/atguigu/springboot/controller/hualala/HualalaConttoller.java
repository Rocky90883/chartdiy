package com.atguigu.springboot.controller.hualala;

import com.alibaba.druid.sql.PagerUtils;
import com.atguigu.springboot.bean.PageVo;
import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import com.atguigu.springboot.bean.hualala.dto.BdhualalaDto;
import com.atguigu.springboot.bean.hualala.vo.HualalaVo;
import com.atguigu.springboot.common.type.ErrorCode;
import com.atguigu.springboot.mapper.hualala.BdhualalaMapper;
import com.atguigu.springboot.my.bean.MessageBean;
import com.atguigu.springboot.utils.JacksonUtil;
import com.atguigu.springboot.utils.PageUtil;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hualala")
public class HualalaConttoller {

    @Autowired
    private BdhualalaMapper hualalaMapper;

//    @RequestMapping(value="queryById", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    @RequestMapping(value="queryById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BdhualalaBean queryById(@PathVariable("id") String id){
        return hualalaMapper.selectByPrimaryKey(id);
    }

    @GetMapping(path="queryByIdOrderStatus",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MessageBean<PageVo<HualalaVo>> queryByIdOrderStatus(  @RequestParam("orderStatus") String orderStatus,
                                                   @RequestParam ("pageNum") Integer pageNum,
                                                   @RequestParam ("size") Integer size,
                                                    String shopName,
                                                    String areaName,
                                                    Integer maxreportDate,
                                                    Integer minreportDate,
                                                    String shopID,
                                                    String sortField,
                                                    String sortType){

        BdhualalaDto bdhualalaDto = new BdhualalaDto();
        bdhualalaDto.setOrderStatus(orderStatus);
        bdhualalaDto.setSize(size);
        bdhualalaDto.setBegin(pageNum);

        List<BdhualalaBean> hualalDate = hualalaMapper.selectByOrderSubType(bdhualalaDto);

        List<HualalaVo> hualalvievListvo = new ArrayList<>();
        for(BdhualalaBean bean : hualalDate){
            hualalvievListvo.add(new HualalaVo(bean));
        }

        //分页总行  总页数
        int rows = hualalaMapper.countselectByOrderSubType(bdhualalaDto);
        int totalPage = PageUtil.getTotalPage(rows,size);

        PageVo<HualalaVo> pageVo = new PageVo<>();
        pageVo.setDataList(hualalvievListvo);
        pageVo.setRows(rows);
        pageVo.setTotalPage(totalPage);

        MessageBean<PageVo<HualalaVo>> mb = new MessageBean<>();
        mb.setMessage(ErrorCode.SUCCESS.getName());
        mb.setCode(ErrorCode.SUCCESS.getCode());
        mb.setData(pageVo);

        return mb;
    }
}


















