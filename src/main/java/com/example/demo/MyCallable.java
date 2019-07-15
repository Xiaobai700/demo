package com.example.demo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    private static int i = 0;
    @Override
    public Object call() throws Exception {
        i++;
        return i;
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2= new MyCallable();
        MyCallable myCallable3 = new MyCallable();
        FutureTask<Integer> ft1 =new FutureTask<>(myCallable1);
        FutureTask<Integer> ft2 =new FutureTask<>(myCallable2);
        FutureTask<Integer> ft3 =new FutureTask<>(myCallable3);
        Thread thread1 = new Thread(ft1);
        Thread thread2 = new Thread(ft2);
        Thread thread3 = new Thread(ft3);

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(ft1.get());
        System.out.println(ft2.get());
        System.out.println(ft3.get());
    }
}
