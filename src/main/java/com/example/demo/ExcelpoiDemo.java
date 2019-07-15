package com.example.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelpoiDemo {
    /**
     * poi写Excel
     * @param pathName 文件路径
     * @param sheetName 表格的名称
     * @param style 表格的格式
     * @param titles 表头信息
     * @param datas 表格信息
     * */
    public static void writeExcel(String pathName, String sheetName, String style, List<String> titles,List<String> datas)
    throws Exception{
        Workbook workbook;
        if(".XLS".equals(style.toUpperCase())){
            workbook = new HSSFWorkbook();
        }else {
            workbook = new XSSFWorkbook();
        }

        Sheet sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        //创建表头信息
        for(int i = 0;i < titles.size();i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
        }

        //创建表格信息
        int index = 0;
        while (index < 5){
            index++;
            row = sheet.createRow(index);
            for(int i = 0;i < 5;i++){
                Cell cell = row.createCell(i);
                cell.setCellValue("hello");
            }
        }
        /*
         * 写入到文件中*/
        File file = new File(pathName);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(null != outputStream){
                    outputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * poi读Excel
     * */
    public static void readExcel(String pathName) throws IOException {
        File file = new File(pathName);
        FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
        HSSFWorkbook hssfWorkbook = null;
        XSSFWorkbook xssfWorkbook = null;

        Sheet sheet = null;
        //indexOf(String str)返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            sheet = xssfWorkbook.getSheetAt(0);
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        String first = "";
        String second = "";
        for(int i = firstRowNum;i <= lastRowNum;i++){
            Row row = sheet.getRow(i);
            if(row != null){
                if(row.getCell(0) != null){
                    row.getCell(0).setCellType(CellType.STRING);
                    first = row.getCell(0).getStringCellValue();
                }
                if(row.getCell(1) != null){
                    row.getCell(1).setCellType(CellType.STRING);
                    second = row.getCell(1).getStringCellValue();
                }
            }
            System.out.println("第" + i + "行信息为：" + first + " | " + second);
            }
        }

    public static void main(String[] args) throws Exception{
        List<String> titles = new ArrayList<>();
        titles.add("姓名");
        titles.add("性别");
        titles.add("年龄");
        titles.add("爱好");
        titles.add("职业");

        List<String> datas = new ArrayList<>();
        datas.add("张三");
        datas.add("男");
        datas.add("20");
        datas.add("看书");
        datas.add("学生");
        //writeExcel("f:\\hi.xls","hi","xls",titles,datas);
        readExcel("f:\\hello.xlsx");
        readExcel("f:\\hi.xls");
    }
}
