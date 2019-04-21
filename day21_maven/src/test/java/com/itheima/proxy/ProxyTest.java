package com.itheima.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * ProxyTest
 *
 * @author Huang
 * @date 2019/3/7 23:44
 */
public class ProxyTest {

    @Test
    public void main() throws Exception{

        //1.创建目标对象
        Service service = new ServiceImpl();
        //2.使用Proxy工具类 创建代理对象
        Service o = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("事务开启");
                    Object invoke = method.invoke(service, args);
                    System.out.println("事务关闭");
                    return invoke;
                });
        //3.调用代理对象方法
        o.add();
    }
}
