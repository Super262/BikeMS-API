package com.imooc.controller;

import com.imooc.pojo.User;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@Api(value="用户相关业务的接口", tags= {"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@ApiOperation(value="查询用户信息", notes="查询用户信息的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="ID", paramType="query",dataType="String"),
			@ApiImplicitParam(name="name",value="姓名", paramType="query",dataType="String"),
			@ApiImplicitParam(name="phone",value="手机号", paramType="query",dataType="String"),
			@ApiImplicitParam(name="moneyL",value="押金（下限）", required=true, paramType="query",dataType="Float"),
			@ApiImplicitParam(name="moneyH",value="押金（上限）", required=true, paramType="query",dataType="Float"),
			@ApiImplicitParam(name="city",value="城市", paramType="query",dataType="String")
	})
	@PostMapping("/query")
	public IMoocJSONResult query(String id,
								 String name,
								 String phone,
								 Float moneyL, Float moneyH,
								 String city) {

		try{
			List<User> result=userService.queryUserInfo(id, name, phone, moneyL, moneyH, city);
			return IMoocJSONResult.ok(result);
		}
		catch (Exception e){
			return IMoocJSONResult.errorMsg("查询失败！");
		}
	}
	
}
