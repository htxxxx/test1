package com.itheima.threadlocal;

import org.junit.Test;

/**
 * MyTest
 *
 * @author Huang
 * @date 2019/3/7 23:37
 */
public class MyTest {
    public static final ThreadLocal<Object> tl = new ThreadLocal<>();

    @Test
    public void main() throws Exception{
        MyService myService = new MyService();
        myService.add();
    }
}