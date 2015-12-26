package com.lizhi;
import com.jd.helloworld.domain.example.Example;
import redis.clients.jedis.Jedis;
/**
 * Created by lizhi1 on 14-8-15.
 */
public class RedisUtil {
    private Jedis jedis;
    public void setJedis(Jedis jedis){
        this.jedis=jedis;
    }

    public void put(Example example){
        jedis.set(String.valueOf(example.getId()),example.getName());
    }

    public String get(Example example){
        return jedis.get(String.valueOf(example.getId()));
    }
    public void del(Example example){
        jedis.del(String.valueOf(example.getId()));
    }

    public void put(String key,String value){
        jedis.set(key,value);
    }

    public String get(String key){
        return jedis.get(key);
    }

    public void incr(String key){
        jedis.incr(key);
    }

    public void expire(String key,int seconds){
        jedis.expire(key ,seconds);
    }

    public boolean exists(String key){
        return jedis.exists(key);
    }
}
