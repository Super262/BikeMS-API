package com.imooc.service.impl;

import com.imooc.mapper.CityMapper;
import com.imooc.pojo.City;
import com.imooc.service.CityService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityMapper cityMapper;

    @Autowired
    private Sid sid;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<City> queryCityInfo(String id,String name,
                                    String use_mode,String op_mode,
                                    String leader,
                                    Integer opTimeL,Integer opTimeH,
                                    String operator) throws Exception {

        Example cityExample = new Example(City.class);
        Example.Criteria criteria = cityExample.createCriteria();

        if(!StringUtils.isBlank(id)){
            criteria.andEqualTo("id", id);
        }

        if(!StringUtils.isBlank(name)){
            criteria.andEqualTo("name", name);
        }

        if(!StringUtils.isBlank(use_mode)){
            criteria.andEqualTo("useMode", use_mode);
        }

        if(!StringUtils.isBlank(op_mode)){
            criteria.andEqualTo("opMode", op_mode);
        }

        if(!StringUtils.isBlank(leader)){
            criteria.andEqualTo("leader", leader);
        }

        if(opTimeL.compareTo(-1)!=0){
            criteria.andGreaterThanOrEqualTo("opTime", opTimeL);
        }
        if(opTimeH.compareTo(-1)!=0){
            criteria.andLessThanOrEqualTo("opTime", opTimeH);
        }


        if(!StringUtils.isBlank(operator)){
            criteria.andEqualTo("operator", operator);
        }

        return cityMapper.selectByExample(cityExample);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveCity(City city) throws Exception {
        String cityId = sid.nextShort();
        city.setId(cityId);
        cityMapper.insert(city);
    }
}
