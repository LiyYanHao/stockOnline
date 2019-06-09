package com.learn.springBoot.springbootCoreThinking.Chapter8_3_2_profilejdk;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/9
 * Time: 18:51
 * Description: No Description
 */
@Service
@Profile("Java7")
public class IterationCalcultatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        int sum=0;
        for (Integer intTemp:values) {
            sum+=intTemp;
        }
        System.out.printf("[Java 7 迭代实现] %s 累加结果 : %d\n", Arrays.asList(values), sum);
        return sum;
    }
}
