package com.config;

import com.config.Factory.JedisClusterFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import redis.clients.jedis.JedisCluster;

/**
 * @author lyh on 2019/1/18
 */
@Configuration
public class RedisConfig {

    private Resource AddressConfig =new ClassPathResource("connect-redis.properties");

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public GenericObjectPoolConfig genericObjectPoolConfig(){
        GenericObjectPoolConfig config =new GenericObjectPoolConfig();
        config.setMaxWaitMillis(-1);
        config.setMaxTotal(1000);
        config.setMinIdle(8);
        config.setMaxIdle(100);
        return config;
    }

    @Bean
    public JedisCluster jedisClusterFactory()throws Exception{
        JedisClusterFactory jedisClusterFactory = new JedisClusterFactory();
        jedisClusterFactory.setAddressConfig(AddressConfig);
        jedisClusterFactory.setAddressKeyPrefix("address");
        jedisClusterFactory.setTimeout(30000);
        jedisClusterFactory.setMaxRedirections(6);
        jedisClusterFactory.setGenericObjectPoolConfig(genericObjectPoolConfig());
        jedisClusterFactory.afterPropertiesSet();
        JedisCluster jedisCluster= jedisClusterFactory.getObject();
        logger.info("jedisCluster===="+jedisCluster);
        return jedisCluster;
    }

}
