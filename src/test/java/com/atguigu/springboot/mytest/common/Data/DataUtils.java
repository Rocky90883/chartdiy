package com.atguigu.springboot.mytest.common.Data;

import com.atguigu.springboot.mytest.Bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {


    public static List<Employee> getListEmployee(){

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("单洛祺",26,20000));
        list.add(new Employee("五六七",26,10000));
        list.add(new Employee("阿鬼",22,50000));
        list.add(new Employee("单龙达",6,100));
        list.add(new Employee("啊爷",17,50000));
        list.add(new Employee("鬼佬",20,15000));
        list.add(new Employee("路星河",23,60000));
        list.add(new Employee("路招摇",25,90000));
        list.add(new Employee("Rocky",17,25000));
        list.add(new Employee("vicky",20,21000));
        list.add(new Employee("procky",17,22000));
        list.add(new Employee("小单",26,23000));

        return list;

    }

}
