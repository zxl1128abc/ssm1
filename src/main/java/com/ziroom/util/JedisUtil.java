package com.ziroom.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {//Jedis工具类
    private static JedisPool jedisPool;
    static{
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxWaitMillis(5000);
        //第二个参数指虚拟机的ip地址，第三个参数为端口号
        jedisPool=new JedisPool(config,"192.168.72.128",6379);
    }
    //获取jedis资源
    public static Jedis getJedis(){
        Jedis jedis=jedisPool.getResource();
        return jedis;
    }
    //关闭jedis
    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
    //进行测试
    public static void main(String[] args){
        Jedis jedis=getJedis();
        jedis.select(0);//选择第几号数据库
        //将手机号看做key 短信验证码看做value  第二个参数表示验证码存入redis中的时间
        jedis.setex("13261693136",300,"ssdh");
    }
}
