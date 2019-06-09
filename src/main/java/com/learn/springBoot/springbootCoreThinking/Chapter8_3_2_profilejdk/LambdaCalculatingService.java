package com.learn.springBoot.springbootCoreThinking.Chapter8_3_2_profilejdk;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/9
 * Time: 18:46
 * Description: No Description
 */
@Service
@Profile("Java8")
public class LambdaCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        Integer sum = Stream.of(values).reduce(0, Integer::sum);
        System.out.printf("[Java 8 Lambda实现] %s 累加结果 : %d\n", Arrays.asList(values), sum);
        return sum;
    }
}
