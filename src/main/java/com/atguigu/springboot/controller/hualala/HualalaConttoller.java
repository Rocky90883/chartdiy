package com.atguigu.springboot.controller.hualala;

import com.atguigu.springboot.bean.hualala.Bdhualala;
import com.atguigu.springboot.mapper.hualala.BdhualalaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hualala")
public class HualalaConttoller {

    @Autowired
    private BdhualalaMapper hualalaMapper;


//    @RequestMapping(value="queryById", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value="queryById/{id}", method = RequestMethod.GET)
    public Bdhualala queryById(@PathVariable("id") String id){
        Bdhualala bean = new Bdhualala();
        System.out.println(hualalaMapper.selectByPrimaryKey(id));
        bean = hualalaMapper.selectByPrimaryKey(id);
        return bean;
    }


}
