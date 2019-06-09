package com.learn.springBoot.springbootCoreThinking.Chapter8_3_2_profilejdk;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/9
 * Time: 18:45
 * Description: No Description
 */
public interface CalculatingService {

    /**
     * 累加接口
     * @param values
     * @return
     */
    Integer sum(Integer... values);
}
