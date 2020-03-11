package com.atguigu.springboot.controller.hualala;

import com.atguigu.springboot.bean.hualala.Bdhualala;
import com.atguigu.springboot.mapper.hualala.BdhualalaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hualala")
public class HualalaConttoller {

    @Autowired
    private BdhualalaMapper hualalaMapper;

//    @RequestMapping(value="queryById", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    @RequestMapping(value="queryById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bdhualala queryById(@PathVariable("id") String id){
        return hualalaMapper.selectByPrimaryKey(id);
    }

    @RequestMapping(value="queryByIdOrderStatus", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Bdhualala> queryByIdOrderStatus(@RequestBody Bdhualala  bdhualala,String wo,String ai,String ni){

        System.out.println(wo+ai+ni);
        System.out.println(bdhualala.getOrderStatus());
        return hualalaMapper.selectByOrderSubType(bdhualala);
    }
}
