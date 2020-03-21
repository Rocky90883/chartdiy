package com.atguigu.springboot.utils;

import com.atguigu.springboot.target.Description;
import javafx.beans.binding.ObjectExpression;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Excel工具类
 */
public class ExcelUtil {

    /**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param excelData Excel表格的数据，封装为List<List<String>>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<List<String>> excelData,
                                   String sheetName,
                                   String fileName,
                                   int columnWidth) throws IOException {

        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0;
        for(List<String> data : excelData){
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);

            //遍历添加本行数据
            for (int i = 0; i < data.size(); i++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(i);

                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i));

                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");

        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        //刷新缓冲
        response.flushBuffer();

        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }


    /**
     * 传入要显示excel头部的VO，所有vo的变量需要Description注解
     * @param beanName
     * @return
     */
    public static Map getFieldDescription(String beanName){
        Map<String,String> fieldMap = new HashMap();
        List<String> sortList = null;
        try{
            Class clazz = Class.forName(beanName);
            Field[] declaredFields = clazz.getDeclaredFields();
            sortList =  Arrays.asList(new String[declaredFields.length]);
            System.out.println(declaredFields.length);
            for(Field f: declaredFields){
                if(f.isAnnotationPresent(Description.class)){                   //判断字段是否含有Description注解
                    for(Annotation ann : f.getDeclaredAnnotations()){            //获得所有注解
                        if(ann.annotationType().equals(Description.class)){     //获得Description 注解
                            Description an = (Description) ann;
                            fieldMap.put(f.getName(), an.zh_Name());         //获得字段中文与字段英文
                            sortList.set(an.sort(),f.getName());             //获取字段的排序号
                        }
                    }
                }else{
                    BaseEnv.log.info("请求为参数VO Bean的变量加description注解");
                    throw new NullPointerException();
                }
            }
        }catch (Exception e){
            BaseEnv.log.info("解释Bean字段异常");
            e.printStackTrace();
        }

        Map<String,String> linkedHashMap = new LinkedHashMap();
        for(int i=0;i<sortList.size();i++){
            linkedHashMap.put(sortList.get(i),fieldMap.get(sortList.get(i)));
        }
        BaseEnv.log.debug("排序字段:"+linkedHashMap);
        return linkedHashMap;
    }

}
