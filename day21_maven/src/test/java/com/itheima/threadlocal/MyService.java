package com.itheima.threadlocal;

/**
 * MyService
 *
 * @author Huang
 * @date 2019/3/7 23:37
 */
public class MyService {
    void add(){

        MyTest.tl.set("tl");
        MyDao myDao = new MyDao();
        myDao.add();

    }
}
