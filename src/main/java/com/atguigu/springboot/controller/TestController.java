package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.bean.OrderInfo;
import com.atguigu.springboot.config.bean.Myproperties;
import com.atguigu.springboot.type.enums.OrderInfoEnum;
import com.atguigu.springboot.mapper.secondary.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private Myproperties myproperties;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    /**
     * 测试读取resources/config/my-web.properties路径下的.properties配置文件
     * @return
     */
    @RequestMapping(value = "properties", method = RequestMethod.GET)
    public String properties() {
        String webName = myproperties.getName();
        String webVersion = myproperties.getVersion();
        String webAuthor = myproperties.getAuthor();
        return "webName: "+myproperties.getName()+", webVersion: "+
                myproperties.getVersion()+", webAuthor: "+myproperties.getAuthor();
    }

    /**
     *对[{"id":"12321321","lastName":"单洛祺","gender":"1","email":"452527164@qq.com","dId":"123213213"}]数据
     * 的post进行收据接受测试
     * 注意orderStatus参数需拼在url后面
     * @param employee
     * @param orderStatus
     * @return
     */
    @RequestMapping(value = "postObject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String postObject(@RequestBody List<Employee> employee, String orderStatus) {
        System.out.println(12334);
        System.out.println(employee.get(0).getdId());
        System.out.println(orderStatus);
        return "123";
    }

    /**
     *
     * @param name
     * @param orderStatus
     * @return
     */
    @RequestMapping(value = "testnotnull", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testnotnull(String orderStatus, String name) {

        System.out.println(12334);
        System.out.println(orderStatus);
        System.out.println(name);
        return "123";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String selectTest(){
        List<OrderInfo> orderInfos = orderInfoMapper.selectByStatusList(OrderInfoEnum.b);
        System.out.println(orderInfos);
        return orderInfos.toString();

    }

}
