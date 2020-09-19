package com.imooc.service.impl;

import com.imooc.mapper.BikeMapper;
import com.imooc.mapper.BikelogMapper;
import com.imooc.pojo.Bike;
import com.imooc.pojo.Bikelog;
import com.imooc.pojo.vo.BikelogVO;
import com.imooc.service.BikeService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private Sid sid;

    @Autowired
    private BikeMapper bikeMapper;

    @Autowired
    private BikelogMapper bikelogMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveBike(Bike bike) throws Exception {
        bike.setId(sid.nextShort());
        bikeMapper.insert(bike);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<BikelogVO> queryBikeInfo(String id,Integer time,String city) throws Exception {

        Example bikeExample = new Example(Bike.class);
        Example.Criteria bikeCriteria = bikeExample.createCriteria();

        if(!StringUtils.isBlank(id)){
            bikeCriteria.andEqualTo("id", id);
        }

        if(!StringUtils.isBlank(city)){
            bikeCriteria.andEqualTo("city", city);
        }

        List<Bike> bikeList = bikeMapper.selectByExample(bikeExample);
        List<BikelogVO> bikelogVOList = new ArrayList<>();

        for (Bike bike : bikeList) {
            String bikeId = bike.getId();

            Example bikelogExample = new Example(Bikelog.class);
            Example.Criteria bikelogCriteria = bikelogExample.createCriteria();
            bikelogCriteria.andEqualTo("bikeId", bikeId);

            List<Bikelog> bikelogList = bikelogMapper.selectByExample(bikelogExample);

            bikelogList.removeIf(bikelog -> bikelog.getTime() > time);


            if(bikelogList.size()>0){
                Bikelog max = bikelogList.get(0);

                for (Bikelog bikelog : bikelogList) {
                    if(bikelog.getTime() > max.getTime()){
                        max = bikelog;
                    }
                }

                BikelogVO temp = new BikelogVO(max.getId(),bike.getCity(),max.getTime(),bike.getId(),max.getPosition());
                bikelogVOList.add(temp);
            }
        }


        return bikelogVOList;

    }
}
