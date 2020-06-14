package com.atguigu.springboot.demo;

//import com.atguigu.springboot.target.Description;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import com.atguigu.springboot.utils.BaseEnv;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {


    /**
     * 传入要显示excel头部的VO，所有vo的变量需要Description注解
     * @param beanName  类全称
     * @return
     */
    public static List<Map<String,String>> getFieldDescription(String beanName){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> mainMap = new HashMap();
        Map<String,String> detMap = new HashMap();
        List<String> sortList = null;
        try{
            Class clazz = Class.forName(beanName);
            Field[] declaredFields = clazz.getDeclaredFields();
            sortList =  Arrays.asList(new String[declaredFields.length]);
            System.out.println(declaredFields.length);
            for(Field f: declaredFields){
                if(f.isAnnotationPresent(Excel.class)){                   //判断字段是否含有Description注解
                    for(Annotation ann : f.getDeclaredAnnotations()){            //获得所有注解
                        if(ann.annotationType().equals(Excel.class)){     //获得Description 注解
                            Excel an = (Excel) ann;
                            mainMap.put(f.getName(), an.name());         //获得字段中文与字段英文
//                            sortList.set(an.sort(),f.getName());             //获取字段的排序号
                        }
                    }
                }else if(f.isAnnotationPresent(ExcelCollection.class)){
                    for(Annotation ann : f.getDeclaredAnnotations()){            //获得所有注解
                        if(ann.annotationType().equals(ExcelCollection.class)){     //获得Description 注解
                            ExcelCollection an = (ExcelCollection) ann;
                            detMap.put(f.getName(), an.name());         //获得字段中文与字段英文
                        }
                    }
                }else{
                    BaseEnv.log.info("请求为参数VO Bean的变量加Excel注解");
                    throw new NullPointerException();
                }
            }
        }catch (Exception e){
            BaseEnv.log.info("解释Bean字段异常");
            e.printStackTrace();
        }
        list.add(mainMap);
        list.add(detMap);

//        Map<String,String> linkedHashMap = new LinkedHashMap();
//        for(int i=0;i<sortList.size();i++){
//            linkedHashMap.put(sortList.get(i),fieldMap.get(sortList.get(i)));
//        }
//        BaseEnv.log.debug("排序字段:"+list);
        return list;
    }



    // Excel 导出 通过浏览器下载的形式
    public static void export(HttpServletResponse response, Workbook workbook, String fileName) throws IOException {
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        BufferedOutputStream bufferedOutPut = new BufferedOutputStream(response.getOutputStream());
        workbook.write(bufferedOutPut);
        bufferedOutPut.flush();
        bufferedOutPut.close();
    }

    public static String getnumber(){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(date+"00001000"+getTwo()+"00"+seconds+getTwo());
//        }
        return  date+"_"+getTwo()+"_"+seconds+getTwo();
    }

    /**
     * 产生随机的2位数
     * @return
     */
    public static String getTwo(){
        Random rad=new Random();

        String result  = rad.nextInt(100) +"";

        if(result.length()==1){
            result = "0" + result;
        }
        return result;
    }
}
