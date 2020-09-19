package com.imooc.service;

import com.imooc.pojo.User;

import java.util.List;

public interface UserService {
	
	/**
	 * @Description: 查询用户信息
	 */
	public List<User> queryUserInfo(String id,
									String name,
									String phone,
									Float moneyL,Float moneyH,
									String city) throws Exception;
}
