package com.example.demo;

import java.io.*;

public class IODemo {

    public static void main(String[] args) throws FileNotFoundException,IOException {
        //几种读取文件的方式
        //方式1
        //读取文件 字节流
        InputStream inputStream = new FileInputStream("f:\\zhangqiao1.txt");
        //写入相应的文件
        OutputStream outputStream = new FileOutputStream("f:\\zhangqiao2.txt");
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容
        int n = -1;
        //循环取出数据
        while ((n = inputStream.read(bytes,0,bytes.length)) != -1){
            String str = new String(bytes,0,n,"GBK");
            System.out.println(str);
            outputStream.write(bytes,0,n);
        }
        inputStream.close();
        outputStream.close();
        //方式2
        //读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("f:\\zhangqiao1.txt"));
        //写入相应的文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("f:\\zhangqiao2.txt"));
        //读取数据
        //一次性取出多少字节
        byte[] bytes1 = new byte[2048];
        //接受读取的内容
        int n1 = -1;
        //循环取出数据
        while ((n1 = bufferedInputStream.read(bytes1,0,bytes1.length)) != -1){
            //转换成字符串
            String str1 = new String(bytes1,0,n1,"GBK");
            System.out.println(str1);
            bufferedOutputStream.write(bytes1,0,n1);
        }
        //清除缓存
        bufferedOutputStream.flush();
        //关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();

        //方式3
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("f:\\zhangqiao1.txt"),"GBK");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("f:\\zhangqiao2.txt"),"GBK");
        char[] data = new char[1024];
        int n2 = -1;
        while ((n2 = inputStreamReader.read(data)) != -1){
            String str2 = new String(data,0,n2);
            System.out.println(str2);
            outputStreamWriter.write(str2);
        }
        outputStreamWriter.flush();
        inputStreamReader.close();
        outputStreamWriter.close();


        //方式4 字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("f:\\zhangqiao1.txt"),"GBK"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("f:\\zhangqiao2.txt"),"GBK"));

        String str3 = null;

        while ((str3 = bufferedReader.readLine()) != null){
            System.out.println(str3);
            bufferedWriter.write(str3);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();

       //方式五
        Reader reader = new InputStreamReader(new FileInputStream("f:\\zhangqiao1.txt"),"GBK");

        PrintWriter printWriter = new PrintWriter(new FileWriter("f:\\zhangqiao2.txt"));

        char[] data1 = new char[1024];

        int n3 = -1;

        while ((n3 = reader.read(data1)) != -1){
            String str2 = new String(data1,0,n3);
            System.out.println(str2);
            printWriter.write(str2);
        }
        printWriter.flush();
        printWriter.close();
        reader.close();




    }
}
