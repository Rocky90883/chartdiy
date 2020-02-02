package com.atguigu.springboot.mytest;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 测试日志输出，
 * SLF4J 日志级别从小到大trace,debug,info,warn,error
 *
 * @Author niujinpeng
 * @Date 2018/12/11 21:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogbackTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLog() {
        logger.trace("Trace 日志...");
        logger.debug("Debug 日志...");
        logger.info("Info 日志...");
        logger.warn("Warn 日志...");
        logger.error("Error 日志...");
    }

    @Test
    public void obejctTypeof(){
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setName("单洛祺");
        person.setNumber("123444");
        list.add(person);
        list.add(person);
        list.add(person);
        PaageVo<Person> pgvo = new PaageVo<>();
        pgvo.setDataList(list);
        pgvo.setRows(3);
        pgvo.setTotalPage(100);
        JSONObject jsonObject = JSONObject.fromObject(person);
        JSONArray jsonObject2 = JSONArray.fromObject(list);
        JSONArray jsonObject3 = JSONArray.fromObject(pgvo);
        JSONArray jsonObject4 = JSONArray.fromObject(person);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject2.toString());
        System.out.println(jsonObject3.toString());
        System.out.println(jsonObject4.toString());
        JSONArray jsonObject5 = JSONArray.fromObject(jsonObject4);
        System.out.println();
        System.out.println();
        System.out.println(list.getClass());

    }


}
