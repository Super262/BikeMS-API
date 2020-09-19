package com.imooc.service;

import com.imooc.pojo.Orderlog;

import java.util.List;

public interface OrderlogService {
    /**
     * @Description: 查询订单信息
     */
    public List<Orderlog> queryOrderlogInfo(String id,
                                            String city,
                                            String bikeId,
                                            String username,String phone,
                                            Float mileageL,Float mileageH,
                                            Integer durationL,Integer durationH,
                                            String status,
                                            Integer startTimeL,Integer startTimeH,
                                            Integer finishTimeL,Integer finishTimeH,
                                            Float standardCostL,Float standardCostH,
                                            Float actualCostL,Float actualCostH) throws Exception;

    /**
     * @Description: 结束一个订单
     */
    public void updateOrderlog(Orderlog orderlog) throws Exception;

}
