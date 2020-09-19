package com.imooc.controller;


import com.imooc.pojo.Role;
import com.imooc.service.RoleService;
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
@Api(value="角色相关业务的接口", tags= {"角色相关业务的controller"})
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value="查询角色信息", notes="查询角色信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="角色ID", paramType="query",dataType="String"),
            @ApiImplicitParam(name="name",value="角色名", paramType="query",dataType="String"),
    })
    @PostMapping("/query")
    public IMoocJSONResult query(String id, String name){
        try{
            List<Role> result = roleService.queryRoleInfo(id, name);
            return IMoocJSONResult.ok(result);
        }catch(Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }

    }

    @ApiOperation(value="创建角色", notes="创建角色的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="角色名称", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="status",value="状态", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="operator",value="开通人ID", paramType="query", required=true, dataType="String"),
    })
    @PostMapping("/add")
    public IMoocJSONResult add(String name, Integer status, String operator){
        try{
            Role role= new Role();
            role.setName(name);
            role.setStatus(status);
            role.setOperator(operator);
            roleService.saveRole(role);
            return IMoocJSONResult.ok(role);
        }catch (Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }

    }

    @ApiOperation(value="设置权限", notes="设置权限的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="角色ID", paramType="query", required=true, dataType="String"),
            @ApiImplicitParam(name="status",value="状态", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="menus",value="菜单列表", paramType="query", required=true, dataType="String"),
    })
    @PostMapping("/setPermission")
    public IMoocJSONResult setPermission(String id, Integer status, String menus){
        try{
            Role role= new Role();
            role.setId(id);
            role.setStatus(status);
            role.setMenus(menus);
            roleService.setPermission(role);
            return IMoocJSONResult.ok(role);
        }catch (Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }
    }
}
