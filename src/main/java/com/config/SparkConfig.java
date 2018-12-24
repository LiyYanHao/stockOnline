package com.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author lyh on 2018/12/19
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SparkConfig {

    @Autowired
    private Environment env;

    @Value("${app.name}")
    private String appName;

    @Value("${spark.home}")
    private String sparkHome;

    @Value("${master.uri}")
    private String uri;

    @Bean
    public SparkConf sparkConf(){
        System.setProperty("hadoop.home.dir", "D:\\Program Files\\spark-2.3.2-bin-hadoop2.7");
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setSparkHome(sparkHome)
                .setMaster(uri);

        return sparkConf;
    }


    @Bean
    public JavaSparkContext javaSparkContext(){ return new JavaSparkContext(sparkConf());}

    @Bean
    public SparkSession sparkSession(){
        return SparkSession.builder()
                .sparkContext(javaSparkContext().sc())
                .appName("java Spark SQL basic example")
                .getOrCreate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }












}
