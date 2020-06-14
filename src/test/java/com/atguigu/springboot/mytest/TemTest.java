package com.atguigu.springboot.mytest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

public class TemTest {


    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\13.xls");

        Workbook wb=new HSSFWorkbook();

        Sheet sheet=wb.createSheet();
        /*
         * 设定合并单元格区域范围
         *  firstRow  0-based
         *  lastRow   0-based
         *  firstCol  0-based
         *  lastCol   0-based
         */
        CellRangeAddress cra=new CellRangeAddress(0, 3, 3, 9);

        //在sheet里增加合并单元格
        sheet.addMergedRegion(cra);

        Row row = sheet.createRow(0);

        Cell cell_1 = row.createCell(2);

        cell_1.setCellValue("When you're right , no one remembers, when you're wrong ,no one forgets .");

        //cell 位置3-9被合并成一个单元格，不管你怎样创建第4个cell还是第5个cell…然后在写数据。都是无法写入的。
        Cell cell_2 = row.createCell(10);

        cell_2.setCellValue("what's up ! ");

        wb.write(fos);

        fos.close();
    }

}
