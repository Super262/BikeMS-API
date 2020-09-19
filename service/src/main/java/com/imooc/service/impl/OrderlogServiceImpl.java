package com.imooc.service.impl;

import com.imooc.mapper.OrderlogMapper;
import com.imooc.pojo.Orderlog;
import com.imooc.service.OrderlogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderlogServiceImpl implements OrderlogService {

    @Autowired
    public OrderlogMapper orderlogMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
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
                                            Float actualCostL,Float actualCostH) throws Exception {

        Example orderlogExample = new Example(Orderlog.class);
        Example.Criteria criteria = orderlogExample.createCriteria();

        if(!StringUtils.isBlank(id)){
            criteria.andEqualTo("id", id);
        }

        if(!StringUtils.isBlank(city)){
            criteria.andEqualTo("city", city);
        }

        if(!StringUtils.isBlank(bikeId)){
            criteria.andEqualTo("bikeId", bikeId);
        }

        if(!StringUtils.isBlank(username)){
            criteria.andEqualTo("username", username);
        }

        if(!StringUtils.isBlank(phone)){
            criteria.andEqualTo("phone", phone);
        }

        if(mileageL.compareTo(-1.0f)!=0){
            criteria.andGreaterThanOrEqualTo("mileage", mileageL);
        }
        if(mileageH.compareTo(-1.0f)!=0){
            criteria.andLessThanOrEqualTo("mileage", mileageH);
        }

        if(durationL.compareTo(-1)!=0){
            criteria.andGreaterThanOrEqualTo("duration", durationL);
        }
        if(durationH.compareTo(-1)!=0){
            criteria.andLessThanOrEqualTo("duration", durationH);
        }

        if(!StringUtils.isBlank(status)){
            criteria.andEqualTo("status", status);
        }

        if(startTimeL.compareTo(-1)!=0){
            criteria.andGreaterThanOrEqualTo("startTime", startTimeL);
        }
        if(startTimeH.compareTo(-1)!=0){
            criteria.andLessThanOrEqualTo("startTime", startTimeH);
        }

        if(finishTimeL.compareTo(-1)!=0){
            criteria.andGreaterThanOrEqualTo("finishTime", finishTimeL);
        }
        if(finishTimeH.compareTo(-1)!=0){
            criteria.andLessThanOrEqualTo("finishTime", finishTimeH);
        }

        if(standardCostL.compareTo(-1.0f)!=0){
            criteria.andGreaterThanOrEqualTo("standardCost", standardCostL);
        }
        if(standardCostH.compareTo(-1.0f)!=0){
            criteria.andLessThanOrEqualTo("standardCost", standardCostH);
        }

        if(actualCostL.compareTo(-1.0f)!=0){
            criteria.andGreaterThanOrEqualTo("actualCost", actualCostL);
        }
        if(actualCostH.compareTo(-1.0f)!=0){
            criteria.andLessThanOrEqualTo("actualCost", actualCostH);
        }

        return orderlogMapper.selectByExample(orderlogExample);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateOrderlog(Orderlog orderlog) throws Exception {
        Example orderlogExample = new Example(Orderlog.class);
        Example.Criteria criteria = orderlogExample.createCriteria();
        criteria.andEqualTo("id", orderlog.getId());
        orderlogMapper.updateByExampleSelective(orderlog, orderlogExample);
    }
}
