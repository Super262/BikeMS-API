package com.imooc.service;

import com.imooc.pojo.Bike;
import com.imooc.pojo.vo.BikelogVO;

import java.util.List;

public interface BikeService {
    /**
     * @Description: 添加单车
     */
    public void saveBike(Bike bike) throws Exception;

    /**
     * @Description: 查询车辆最新信息
     */
    public List<BikelogVO> queryBikeInfo(String id,
                                         Integer time,
                                         String city) throws Exception;
}
