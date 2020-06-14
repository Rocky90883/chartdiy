package com.atguigu.springboot.demo.excel.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.atguigu.springboot.demo.Util;
import com.atguigu.springboot.demo.excel.ExportExcelUtil;
import com.atguigu.springboot.demo.excel.bean.ExperienceInputEntity;
import com.atguigu.springboot.demo.excel.bean.TalentUserInputEntity;
import com.atguigu.springboot.utils.JsonUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

@RestController
public class ImportExcelController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(2);
        List<TalentUserInputEntity> result = ExcelImportUtil.importExcel(multipartFile.getInputStream(),
                TalentUserInputEntity.class, params);
        System.out.println(JsonUtils.objectToJson(result));
        return "woaini";
    }



    @GetMapping("/export")
    public void export(HttpServletResponse rsp) throws Exception {

            List<TalentUserInputEntity> list = new LinkedList<TalentUserInputEntity>();
            TalentUserInputEntity user = new TalentUserInputEntity();
            user.setName("张三");
            user.setPhone("13189164130");
            user.setGender("1");

            List<ExperienceInputEntity> detList = new LinkedList<ExperienceInputEntity>();
            ExperienceInputEntity gzjlOne = new ExperienceInputEntity();
            gzjlOne.setCompanyName("科荣");
            gzjlOne.setIndustry("研发");
            ExperienceInputEntity gzjlTwo = new ExperienceInputEntity();
            gzjlTwo.setCompanyName("粤港");
            gzjlTwo.setIndustry("运维");
            detList.add(gzjlOne);
            detList.add(gzjlTwo);
            user.setExperienceList(detList);
            list.add(user);

            ExportParams exportParams = new ExportParams();
            exportParams.setSheetName("我是sheet名字");
//            exportParams.setTitle("测试");
            // 生成workbook 并导出
        try {
            ExportExcelUtil.exportExcel(list,TalentUserInputEntity.class,"测试模板",rsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
//            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, TalentUserInputEntity.class, list);
//            File savefile = new File("d:/aodo");
//            if (!savefile.exists()) {
//                boolean result = savefile.mkdirs();
//                System.out.println("目录不存在，创建" + result);
//            }
//            FileOutputStream fos = new FileOutputStream("d:/aodo/student.xls");
//            workbook.write(fos);
//            fos.close();
    }

    @PostMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception{
        TalentUserInputEntity user = new TalentUserInputEntity();
        String className = user.getClass().getName();
        System.out.println(className);
        List<Map<String, String>> filedList = Util.getFieldDescription(className);
        System.out.println(filedList.get(0));
        System.out.println(filedList.get(1));
        Map<String, String> mainmap = filedList.get(0);         //主表
//        String title[] = new String[]{"标题1", "标题2", "标题3"};//excel第一行标题内容

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("导入模板");//工作薄名称
        sheet.setDefaultColumnWidth(18);//列宽

        int rowNO = 0;
        HSSFRow row = null;
        HSSFCell cell = null;
        row = sheet.createRow(rowNO++);
        row.setHeight((short) 400);

        int i = 0;
        for(String str : mainmap.keySet()){
            CellRangeAddress cra=new CellRangeAddress(0, 1, i, i);
            sheet.addMergedRegion(cra);
            cell = row.createCell(i);
            cell.setCellValue(mainmap.get(str));
            i = i+1;
        }

        String fileName = "导入模板.xls";//excel文件名
        response.setContentType("application/download;charset=UTF-8");//告诉浏览器返回文件下载
        response.setHeader("Content-disposition", "attachment;filename=\""
                + new String(fileName.getBytes("UTF-8"), "ISO8859_1") + "\"");//激活文件下载保存框
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
        return;
    }


}
