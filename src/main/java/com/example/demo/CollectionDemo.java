package com.example.demo;

import java.util.*;

public class CollectionDemo {

    //通过迭代器遍历自身元素
    public static void iteratorDemo(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(17);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet
    public  static void linkedHashSetDemo(){
        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        // 创建并添加元素
        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");
        hs.add("java");

        // 遍历
        for (String s : hs) {
            System.out.println(s);
        }
    }
    public static void main(String args[]){
        //iteratorDemo();
        linkedHashSetDemo();
    }
}
