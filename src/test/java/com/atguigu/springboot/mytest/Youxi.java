package com.atguigu.springboot.mytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Youxi {

    @Test
    public void she(){

        Integer jian = 100;

        while(jian>0){

            Random ran = new Random();
            Integer num = ran.nextInt(2)+1;
            jian = jian - num;
            System.out.println("a：射出"+num+" 剩余" + jian);
            System.out.println("num:"+num);
            num =  (num/2==1?1:2);
            System.out.println("num2:"+num);
            jian = jian - num;
            System.out.println("b：射出"+num+" 剩余" + jian);


        }

    }

}
