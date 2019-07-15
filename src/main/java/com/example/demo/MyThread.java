package com.example.demo;
import java.lang.Thread;

public class MyThread extends Thread{
    private static int i = 0;

    @Override
    public void run(){
        i++;
        System.out.println(i);
    }
    public static void main(String[] args){
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
