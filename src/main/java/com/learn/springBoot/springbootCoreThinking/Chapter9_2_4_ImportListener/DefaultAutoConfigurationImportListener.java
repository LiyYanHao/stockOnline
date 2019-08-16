package com.learn.springBoot.springbootCoreThinking.Chapter9_2_4_ImportListener;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/11
 * Time: 7:37
 * Description: No Description
 */
public class DefaultAutoConfigurationImportListener implements AutoConfigurationImportListener {
    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent autoConfigurationImportEvent) {
        // 获取当前 ClassLoader
        ClassLoader classLoader = autoConfigurationImportEvent.getClass().getClassLoader();
        // 候选的自动装配类名单
//        List<EnableAutoConfiguration> s =
//                SpringFactoriesLoader.loadFactories(EnableAutoConfiguration.class, classLoader);
        // 实际的自动装配类名单
        List<String> candidateConfigurations = autoConfigurationImportEvent.getCandidateConfigurations();
        // 排除的自动装配类名单
        Set<String> exclusions = autoConfigurationImportEvent.getExclusions();
        // 输出各自数量
        //System.out.printf("自动装配类名单 - 候选数量：%d，实际数量：%d，排除数量：%s\n",
                //enableAutoConfigurations.size(), candidateConfigurations.size(), exclusions.size());
        // 输出实际和排除的自动装配类名单
        System.out.println("实际的自动装配类名单：");
        autoConfigurationImportEvent.getCandidateConfigurations().forEach(System.out::println);
        System.out.println("排除的自动装配类名单：");
        autoConfigurationImportEvent.getExclusions().forEach(System.out::println);

    }
}
