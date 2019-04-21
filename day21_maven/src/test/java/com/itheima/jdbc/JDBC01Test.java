package com.itheima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC01Test
 *
 * @author Huang
 * @date 2019/3/3 11:18
 */
public class JDBC01Test {
    @Test
    public void main() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库连接核心对象
            /*connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "3416");*/
            connection = DriverManager.getConnection("jdbc:mysql:///test?characterEncoding=utf-8", "root", "3416");
            //定义sql语句，
            String sql = "SELECT * FROM user WHERE name = ?";
            //获取预处理对象
            ps = connection.prepareStatement(sql);
            //设置参数
            ps.setString(1, "张三");
            //执行sql，返回结果集
            resultSet = ps.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            resultSet.close();
            ps.close();
            connection.close();
        }
    }
}
