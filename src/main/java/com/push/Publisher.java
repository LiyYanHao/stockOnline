package com.push;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lyh on 2019/1/18
 */
public class Publisher {


    private JedisCluster jedisCluster;

    public Publisher(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public void start() {

        while (true) {
            String line = "hello redis pushlish";
            try {
                //line = reader.readLine();
                if (!"quit".equals(line)) {
                    jedisCluster.publish("mychannel", line);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
