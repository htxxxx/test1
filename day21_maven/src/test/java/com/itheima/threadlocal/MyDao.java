package com.itheima.threadlocal;

/**
 * MyDao
 *
 * @author Huang
 * @date 2019/3/7 23:37
 */
public class MyDao {
    void add(){
        System.out.println(MyTest.tl.get());

        Thread th = new Thread(()->{
            System.out.println(MyTest.tl.get());

        });

        th.start();
    }





}
