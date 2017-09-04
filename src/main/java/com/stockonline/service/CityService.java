package com.stockonline.service;


import com.stockonline.domain.City;

import java.util.Map;

/**
 * 城市业务逻辑接口类
 *
 * Created by xchunzhao on 02/05/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    Map findCityByName(String cityName);
}
