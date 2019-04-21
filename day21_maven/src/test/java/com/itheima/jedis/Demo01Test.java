package com.itheima.jedis;

import com.itheima.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * Demo01Test
 *
 * @author Huang
 * @date 2019/3/3 9:41
 */
public class Demo01Test {
    @Test
    public void testJedis01() throws Exception{
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name","itheima");
        String name = jedis.get("name");
        System.out.println(name);

        jedis.hset("myhash","name","ht");
        Long hset = jedis.hset("myhash", "password", "1234");
        System.out.println(hset);
        String hget1 = jedis.hget("myhash", "name");
        System.out.println(hget1);
        String hget = jedis.hget("myhash", "password");
        System.out.println(hget);

        jedis.close();
    }

    @Test
    public void testJedisPool() throws Exception{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(10);
        JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            String set = jedis.set("name", "itcast");
            System.out.println(set);

            String name = jedis.get("name");
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }

            if(pool != null){
                pool.close();
            }
        }
    }


    @Test
    public void testJedis02() throws Exception{
        //创建jedis
        Jedis jedis = JedisUtils.getJedis();
        //集合类型set
        //写
        jedis.sadd("myset","a","b","c","c");
        //读
        Set<String> myset = jedis.smembers("myset");
        myset.stream().forEach(System.out::println);

        System.out.println("==================================");
        //列表类型list
        //写
        jedis.lpush("mylist","1","2","3","3");
        //读
        String lpop = jedis.lpop("mylist");
        String rpop = jedis.rpop("mylist");
        System.out.println(lpop);
        System.out.println(rpop);
        System.out.println("==================================");

        //哈希类型hash
        //写
        jedis.hset("myhash","username","ht");
        jedis.hset("myhash","password","1234");
        //读
        String username = jedis.hget("myhash", "username");
        String password = jedis.hget("myhash", "password");
        System.out.println(username);
        System.out.println(password);

        //字符串类型
        jedis.set("mystr","one");
        jedis.set("mystr","two");
        String mystr = jedis.get("mystr");
        System.out.println(mystr);
    }
}
