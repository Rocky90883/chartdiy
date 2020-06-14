package com.atguigu.springboot.mytest.common.Data;

import com.atguigu.springboot.mytest.Bean.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {


    public static List<Employee> getListEmployee(){

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("单洛祺",26,20000,new BigDecimal("23424")));
        list.add(new Employee("五六七",26,10000,new BigDecimal("33424")));
        list.add(new Employee("阿鬼",22,60000,new BigDecimal("4323424")));
        list.add(new Employee("单龙达",6,100,new BigDecimal("233424")));
        list.add(new Employee("啊爷",17,50000,new BigDecimal("2343424")));
        list.add(new Employee("鬼佬",20,15000,new BigDecimal("23423424")));
        list.add(new Employee("路星河",23,60000,new BigDecimal("23123424")));
        list.add(new Employee("路招摇",25,90000,new BigDecimal("6787623424")));
        list.add(new Employee("Rocky",17,25000,new BigDecimal("236546424")));
        list.add(new Employee("vickydiss",20,21000,new BigDecimal("354623424")));
        list.add(new Employee("procky",17,22000,new BigDecimal("7523424")));
        list.add(new Employee("小单",26,23000,new BigDecimal("21423424")));

        return list;

    }

}
