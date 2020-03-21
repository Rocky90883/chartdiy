package com.atguigu.springboot.controller.hualala;

import com.alibaba.druid.sql.PagerUtils;
import com.atguigu.springboot.bean.PageVo;
import com.atguigu.springboot.bean.hualala.BdhualalaBean;
import com.atguigu.springboot.bean.hualala.dto.BdhualalaDto;
import com.atguigu.springboot.bean.hualala.vo.HualalaVo;
import com.atguigu.springboot.common.type.ErrorCode;
import com.atguigu.springboot.mapper.hualala.BdhualalaMapper;
import com.atguigu.springboot.my.bean.MessageBean;
import com.atguigu.springboot.target.Description;
import com.atguigu.springboot.utils.*;
import com.sun.deploy.net.HttpResponse;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping("/hualala")
public class HualalaConttoller {

    @Autowired
    private BdhualalaMapper hualalaMapper;

    @Autowired
    private RestTemplate restTemplate;

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

    /**
     * 进入哗啦啦报表
     * @return
     */
    @RequestMapping(value = "dataView")
    public ModelAndView dataView(){
        ModelAndView mv = new ModelAndView("bootstrapTheme/dataView.html");
        return mv;
    }

    /**
     * excel导出
     *
     */
    @RequestMapping(value = "hualalDataExcelOut" , method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void ExcelOut(HttpServletResponse response, @RequestBody BdhualalaDto bdhualalaDto){

        if(bdhualalaDto.getIds()!=null && !bdhualalaDto.getIds().isEmpty()) {
            bdhualalaDto.setIds(StrUtil.replacetoSQLinStr(bdhualalaDto.getIds(), "|", "','"));
        }

        //dto查po
        List<BdhualalaBean> bdhualalaBeans = hualalaMapper.selectByOrderSubType(bdhualalaDto);

        //po转vo
        List<HualalaVo> hualalvievListvo = new ArrayList();
        for(BdhualalaBean bean: bdhualalaBeans){
            hualalvievListvo.add(new HualalaVo(bean));
        }
        System.out.println(hualalvievListvo);
        Map<String,String> fieldMap = new LinkedHashMap();
        fieldMap = ExcelUtil.getFieldDescription("com.atguigu.springboot.bean.hualala.vo.HualalaVo");      //获得 字段说明map

        List<List<String>> excelData = new ArrayList<>();                                           //创建表格模型

        List<String> head = new ArrayList<>();
        for(String key : fieldMap.keySet()){
            if(fieldMap.get(key) != null && !fieldMap.get(key).isEmpty()){
                head.add(fieldMap.get(key));
            }else{
                head.add(key);
            }
        }
        excelData.add(head);                                                                         //拼接头部
        System.out.println(head);
        for(int i=0; i<hualalvievListvo.size(); i++){
            List<String> data = new ArrayList<>();
            Map<String,Object> mapvo = CommonUtil.bean2map(hualalvievListvo.get(i));
            for(String key : fieldMap.keySet()){
                data.add(mapvo.get(key).toString());
            }
            excelData.add(data);                                                                     //拼接内容
        }

        String sheetName = "sheet1";
        String fileName = "numberOne.xls";
        try {
            ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 15);        //响应excel并返回
        } catch (IOException e) {
            e.printStackTrace();
        }

//        MessageBean mb = new MessageBean<>();
//        mb.setMessage(ErrorCode.SUCCESS.getName());
//        mb.setCode(ErrorCode.SUCCESS.getCode());

        return ;
    }
}


















