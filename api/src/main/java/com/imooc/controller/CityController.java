package com.imooc.controller;


import com.imooc.pojo.City;
import com.imooc.service.CityService;
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

import java.util.List;

@RestController
@Api(value="城市相关业务的接口", tags= {"城市相关业务的controller"})
@RequestMapping("/city")
public class CityController{

    @Autowired
    private CityService cityService;

    @ApiOperation(value="查询城市信息", notes="查询城市信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id", paramType="query",dataType="String"),
            @ApiImplicitParam(name="name",value="名称", paramType="query",dataType="String"),
            @ApiImplicitParam(name="useMode",value="用车模式", paramType="query",dataType="String"),
            @ApiImplicitParam(name="opMode",value="营运模式", paramType="query",dataType="String"),
            @ApiImplicitParam(name="leader",value="负责人ID", paramType="query",dataType="String"),
            @ApiImplicitParam(name="opTimeL",value="开通时间（下限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="opTimeH",value="开通时间（上限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="operator",value="开通人ID", paramType="query",dataType="String")
    })
    @PostMapping("/query")
    public IMoocJSONResult query(String id, String name,
                                 String useMode, String opMode,
                                 String leader,
                                 Integer opTimeL, Integer opTimeH,
                                 String operator){

        try{
            List<City> result=cityService.queryCityInfo(
                    id, name,
                    useMode, opMode,
                    leader,
                    opTimeL, opTimeH,
                    operator);

            return IMoocJSONResult.ok(result);
        }
        catch (Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }


    }

    @ApiOperation(value="添加城市", notes="添加城市的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="名称", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="useMode",value="用车模式", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="opMode",value="营运模式", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="leader",value="负责人ID", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="opTime",value="开通时间", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="operator",value="开通人ID", paramType="query", required=true, dataType="String")
    })
    @PostMapping("/open")
    public IMoocJSONResult open(String name,
                                 String useMode, String opMode,
                                 String leader,
                                 Integer opTime,
                                 String operator){
        try{
            City city=new City();
            city.setName(name);
            city.setOpMode(opMode);
            city.setUseMode(useMode);
            city.setLeader(leader);
            city.setOpTime(opTime);
            city.setOperator(operator);
            cityService.saveCity(city);
            return IMoocJSONResult.ok(city);
        }
        catch(Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }

    }

}
