package com.task;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @author lyh on 2019/1/18
 */
public class SubThread extends Thread {


    private JedisCluster jedisCluster;

    public SubThread(JedisCluster jedisCluster){
        this.jedisCluster=jedisCluster;
    }

    private final Subscriber subscriber = new Subscriber();

    private final String channel = "mychannel";
    @Override
    public void run() {
        System.out.println(String.format("subscribe redis, channel %s, thread will be blocked", channel));
        Jedis jedis = null;
        try {
            System.out.println("JedisCluster========="+jedisCluster);
            jedisCluster.subscribe(subscriber, channel);
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
