package com.imooc.controller;

import com.imooc.pojo.Orderlog;
import com.imooc.pojo.vo.OrderlogVO;
import com.imooc.service.OrderlogService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="订单相关业务的接口", tags= {"订单相关业务的controller"})
@RequestMapping("/orderlog")
public class OrderlogController{

    @Autowired
    private OrderlogService orderlogService;

    @ApiOperation(value="查询订单信息", notes="查询订单信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id", paramType="query",dataType="String"),
            @ApiImplicitParam(name="city",value="city", paramType="query",dataType="String"),
            @ApiImplicitParam(name="bikeId",value="bikeId", paramType="query",dataType="String"),
            @ApiImplicitParam(name="username",value="username", paramType="query",dataType="String"),
            @ApiImplicitParam(name="phone",value="phone", paramType="query",dataType="String"),
            @ApiImplicitParam(name="mileageL",value="里程（下限）", required=true, paramType="query",dataType="Float"),
            @ApiImplicitParam(name="mileageH",value="里程（上限）", required=true, paramType="query",dataType="Float"),
            @ApiImplicitParam(name="durationL",value="持续时间（下限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="durationH",value="持续时间（上限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="status",value="status", paramType="query",dataType="String"),
            @ApiImplicitParam(name="startTimeL",value="开始时间（下限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="startTimeH",value="开始时间（上限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="finishTimeL",value="结束时间（下限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="finishTimeH",value="结束时间（上限）", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="standardCostL",value="标准费用（下限）", required=true, paramType="query",dataType="Float"),
            @ApiImplicitParam(name="standardCostH",value="标准费用（上限）", required=true, paramType="query",dataType="Float"),
            @ApiImplicitParam(name="actualCostL",value="实际费用（下限）", required=true, paramType="query",dataType="Float"),
            @ApiImplicitParam(name="actualCostH",value="实际费用（上限）", required=true, paramType="query",dataType="Float")
    })
    @PostMapping("/query")
    public IMoocJSONResult query(String id,
                                 String city,
                                 String bikeId,
                                 String username,
                                 String phone,
                                 Float mileageL,Float mileageH,
                                 Integer durationL,Integer durationH,
                                 String status,
                                 Integer startTimeL,Integer startTimeH,
                                 Integer finishTimeL,Integer finishTimeH,
                                 Float standardCostL,Float standardCostH,
                                 Float actualCostL,Float actualCostH){

        try{
            List<Orderlog> tempResult = orderlogService.queryOrderlogInfo(
                    id,
                    city,
                    bikeId,
                    username,
                    phone,
                    mileageL, mileageH,
                    durationL, durationH,
                    status,
                    startTimeL, startTimeH,
                    finishTimeL, finishTimeH,
                    standardCostL, standardCostH,
                    actualCostL, actualCostH);

            List<OrderlogVO> result = new ArrayList<>();

            for (Orderlog orderlog : tempResult) {
                OrderlogVO vo = new OrderlogVO(orderlog);
                result.add(vo);
            }

            return IMoocJSONResult.ok(result);
        }
        catch (Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }

    }

    @ApiOperation(value="结束订单", notes="结束订单的接口")
    @ApiImplicitParam(name="id",value="id", required=true, paramType="query",dataType="String")
    @PostMapping("/finish")
    public IMoocJSONResult finish(String id){
        try{
            Orderlog orderlog=new Orderlog();
            orderlog.setId(id);
            orderlog.setStatus("2");
            orderlogService.updateOrderlog(orderlog);
            return IMoocJSONResult.ok();
        }
        catch(Exception e){
            return  IMoocJSONResult.errorMsg("操作失败");
        }

    }
}

//[{"lon": 116.361221,"lat": 40.043776}, {"lon": 116.363736,"lat": 40.038086}, {"lon": 116.364599,"lat": 40.036484}, {"lon": 116.373438,"lat": 40.03538}, {"lon": 116.377966,"lat": 40.036263}, {"lon": 116.379762,"lat": 40.03654}, {"lon": 116.38084,"lat": 40.033225}, {"lon": 116.38084,"lat": 40.029413}, {"lon": 116.381343,"lat": 40.021291}, {"lon": 116.381846,"lat": 40.015821}, {"lon": 116.382637,"lat": 40.008084}, {"lon": 116.398806,"lat": 40.008637}]
