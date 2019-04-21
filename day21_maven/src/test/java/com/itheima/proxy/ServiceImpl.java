package com.itheima.proxy;

/**
 * ServiceImpl
 *
 * @author Huang
 * @date 2019/3/7 23:44
 */
public class ServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("添加");
    }

    @Override
    public void delete() {
        System.out.println("删除");

    }
}
