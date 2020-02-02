package com.atguigu.springboot.mytest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {


    @Test
    public void tojson(){
        User user = new User();
        user.setName("单洛祺");
        Kemu kemu = new Kemu();
        kemu.setName("语文");
        List<Kemu> kemulist = new ArrayList<>();
        kemulist.add(kemu);
        user.setKemulist(kemulist);

        try{
            System.out.println(JacksonUtil.toJson(user));
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

}
