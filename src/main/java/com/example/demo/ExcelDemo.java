package com.example.demo;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class ExcelDemo {


    public static void main(String[] args) throws IOException, WriteException, BiffException {

        /**
         * jxl写Excel jxl目前不支持xlsx格式的文件
         * */
        File file = new File("f:\\jxlDemo.xls");
        //创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        //创建一个工作表
        WritableSheet writableSheet = workbook.createSheet("sheet1",0);
        for(int row = 0;row < 10;row++){
            for(int col = 0;col < 10;col++){
                writableSheet.addCell(new Label(col,row,"data"+row+col));
            }
        }
        //向工作表中添加数据
        workbook.write();
        workbook.close();


        /**
         * jxl读Excel
         * */
        File file1 = new File("f:\\jxlDemo.xls");
        //获得工作簿对象
        Workbook workbook1 = Workbook.getWorkbook(file1);
        //获得所有工作表
        Sheet[] sheets = workbook1.getSheets();
        if(sheets != null){
            for (Sheet sheet:sheets) {
                int rows = sheet.getRows();
                int cols = sheet.getColumns();
                for(int col = 0;col < cols;col++){
                    for(int row = 0;row < rows;row++){
                        System.out.printf("%10s",sheet.getCell(col,row).getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbook1.close();


    }
}
