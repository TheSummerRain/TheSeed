package com.seed.myUtil;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * <p>用于便捷使用Redis的工具类</p>
 * Created by lonecloud on 17/3/15.
 *
 * @author lonecloud
 */
public class RedisUtils {

    protected static final Logger log = LoggerFactory.getLogger(RedisUtils.class);


    //设置该类不能实例化
    private RedisUtils() {
    }

    private static Jedis jedis;
    private static String url = PropertyManager.getProperty("redis.url");
    private static int port = Integer.valueOf(PropertyManager.getProperty("redis.port"));
    private static String password = PropertyManager.getProperty("redis.password");
    private static boolean isPool = Boolean.valueOf(PropertyManager.getProperty("redis.isPool"));
    /**
     * 设置默认的超时时间 60*3=180s=3分钟。
     */
    private static int timeout = 60 * 3;

    private static JedisPool jedisPool;

    private static GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

    static {
        //初始化redis
        initRedis();
    }

    /**
     * 获取Jedis 实例
     * @return
     */
    public static Jedis getJedis() {
        if (isPool) {
            if (jedisPool == null) {
                jedisPool = new JedisPool(poolConfig, url, port, timeout, password);
            }
            return jedisPool.getResource();
        } else {
            if (jedis == null) {
                jedis = new Jedis(url, port);
            }
            return jedis;
        }
    }

    /**
     * 将String设置到redis中
     * @param key   键
     * @param value 值
     */
    public static void setString(String key, String value) {
        getJedis().set(key, value);
    }


    /**
     * 通过键获取String
     * @param key 键
     * @return
     */
    public static String getString(String key) {
        return getJedis().get(key);
    }

    /**
     * 将List数组存进redis中
     * @param key    键
     * @param list   String的List对象
     * @param isHead 是否每次插入从头部进行插入
     */
    public static void setList(String key, List<String> list, boolean isHead) {
        String[] arr = new String[list.size()];
        list.toArray(arr);
        //判断是不是从头部开始插入
        if (isHead) {
            getJedis().lpush(key, arr);
        } else {
            getJedis().rpush(key, arr);
        }
        if (log.isDebugEnabled()) {
            log.debug("redis insert a list of " + key + ":" + list);
        }
    }

    /**
     * 获取redis中的数组
     *
     * @param key   键
     * @param start 开始
     * @param end   结束
     * @return
     */
    public static List<String> getList(String key, long start, long end) {
        return getJedis().lrange(key, start, end);
    }

    /**
     * redis存储对象
     *
     * @param key 键
     * @param obj 对象
     * @throws IOException
     */
    public static void setObject(String key, Object obj) throws IOException {
        if (obj != null) {
            byte[] bytes = ObjectUtils.ObjectToBytes(obj);
            getJedis().set(key.getBytes(), bytes);
        } else {
            log.error("没有找到类");
            throw new NullPointerException("没有找到该类");
        }
    }

    /**
     * redis获取对象
     *
     * @param key   键
     * @param clazz 获取的对象类型
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends Serializable> T getObject(String key, Class<T> clazz) throws IOException {
        byte[] bytes = getJedis().get(key.getBytes());
        T obj = ObjectUtils.ObjectFromBytes(bytes, clazz);
        return obj;
    }

    /**
     * 初始化redis参数操作
     */
    private static void initRedis() {

        //判断是否使用pool 如果不使用则是单例的redis
        String proisPool = PropertyManager.getProperty("redis.isPool");
        String proUrl = PropertyManager.getProperty("redis.url");
        String proProt = PropertyManager.getProperty("redis.port");
        String proPass = PropertyManager.getProperty("redis.password");
        //设置全局的配置
        if (proUrl != null && proProt != null && proPass != null) {
            url = proUrl;
            port = Integer.valueOf(proProt);
            password = proPass;
        }
        if (proisPool != null && "true".equals(proisPool.trim())) {
            //设置全局判断变量为true
            isPool = true;
            log.debug("开始执行pool的创建工作");
            jedisPool = new JedisPool(poolConfig, url, port, timeout, password);
            /**
             * 设置默认的redis
             */
            jedis = jedisPool.getResource();
        } else {
            log.debug("开始执行单例redis");
            if (proUrl != null && proProt != null) {
                url = proUrl;
                port = Integer.valueOf(proProt);
            }
            jedis = new Jedis(url, port);
        }

    }


}
