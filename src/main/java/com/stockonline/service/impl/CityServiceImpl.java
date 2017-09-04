package com.stockonline.service.impl;

import com.stockonline.domain.City;
import com.stockonline.mapper.CityDao;
import com.stockonline.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 城市业务逻辑实现类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public Map findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
