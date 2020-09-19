package com.imooc.service;

import com.imooc.pojo.City;

import java.util.List;

public interface CityService {
    /**
     * @Description: 查询城市信息
     */
    public List<City> queryCityInfo(String id, String name,
                                    String useMode, String opMode,
                                    String leader,
                                    Integer opTimeL, Integer opTimeH,
                                    String operator) throws Exception;

    /**
     * @Description: 保存一个城市（添加城市）
     */
    public void saveCity(City city) throws Exception;
}
