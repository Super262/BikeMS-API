package com.imooc.controller;

import com.imooc.pojo.Bike;
import com.imooc.service.BikeService;
import com.imooc.utils.IMoocJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value=" 单车相关业务的接口", tags= {"单车相关业务的controller"})
@RequestMapping("/bike")
public class BikeController{

    @Autowired
    private BikeService bikeService;

    @ApiOperation(value="查询单车信息", notes="查询单车信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="单车id", paramType="query",dataType="String"),
            @ApiImplicitParam(name="time",value="时间", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="city",value="城市", paramType="query",dataType="String"),
    })
    @PostMapping("/query")
    public IMoocJSONResult query(String id,Integer time,String city){
        try{
            if(time.compareTo(-1)==0){
                time= (int) (System.currentTimeMillis() / 1000);
            }
            return IMoocJSONResult.ok(bikeService.queryBikeInfo(id,time,city));
        }
        catch(Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }

    }



    @ApiOperation(value="添加单车", notes="添加单车的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="city",value="城市", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="num",value="数量", required=true, paramType="query",dataType="int"),
    })
    @PostMapping("/add")
    public IMoocJSONResult open(String city, Integer num){

        try{
            for(int i=1; i<=num; ++i){
                Bike bike=new Bike();
                bike.setCity(city);
                bikeService.saveBike(bike);
            }
            return IMoocJSONResult.ok();
        }
        catch(Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }
    }

}
