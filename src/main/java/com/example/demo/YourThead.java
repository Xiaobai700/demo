package com.example.demo;

public class YourThead implements Runnable {
    private static int i = 0;
    @Override
    public void run() {
        i++;
        System.out.println(i);
    }

    public static void main(String[] args){
       YourThead yourThead1 = new YourThead();
       YourThead yourThead2= new YourThead();
       YourThead yourThead3 = new YourThead();

       new Thread(yourThead1).start();
       new Thread(yourThead2).start();
       new Thread(yourThead3).start();


    }
}
