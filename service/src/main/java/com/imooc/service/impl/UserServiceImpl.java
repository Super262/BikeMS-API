package com.imooc.service.impl;

import com.imooc.mapper.UserMapper;
import com.imooc.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.service.UserService;

import tk.mybatis.mapper.entity.Example;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<User> queryUserInfo(String id,
									String name,
									String phone,
									Float moneyL,Float moneyH,
									String city) throws Exception {

		Example userExample = new Example(User.class);
		Example.Criteria criteria = userExample.createCriteria();

		if(!StringUtils.isBlank(id)){
			criteria.andEqualTo("id", id);
		}

		if(!StringUtils.isBlank(name)){
			criteria.andEqualTo("name", name);
		}

		if(!StringUtils.isBlank(phone)){
			criteria.andEqualTo("phone", phone);
		}

		if(moneyL.compareTo(-1.0f)!=0){
			criteria.andGreaterThanOrEqualTo("money", moneyL);
		}

		if(moneyH.compareTo(-1.0f)!=0){
			criteria.andLessThanOrEqualTo("money", moneyH);
		}

		if(!StringUtils.isBlank(city)){
			criteria.andEqualTo("city", city);
		}

		return userMapper.selectByExample(userExample);
	}

}

