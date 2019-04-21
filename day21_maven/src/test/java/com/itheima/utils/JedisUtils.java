package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * JedisUtils
 *
 * @author Huang
 * @date 2019/3/3 9:52
 */
public class JedisUtils {
    private static JedisPoolConfig poolConfig = null;
    private static JedisPool jedisPool = null;
    private static Integer maxTotal =null;
    private static Integer maxIdle =null;
    private static String host =null;
    private static Integer port =null;
    static{
        ResourceBundle rb = ResourceBundle.getBundle("jedis");
        maxTotal = Integer.parseInt(rb.getString("jedis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("jedis.maxIdle"));
        port = Integer.parseInt(rb.getString("jedis.port"));
        host = rb.getString("jedis.host");

        poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        jedisPool = new JedisPool(poolConfig,host,port);

    }

    public static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
