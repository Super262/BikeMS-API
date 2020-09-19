package com.imooc.controller;


import com.imooc.pojo.Staff;
import com.imooc.pojo.vo.StaffRoleVO;
import com.imooc.service.StaffService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value=" 员工相关业务的接口", tags= {"员工相关业务的controller"})
@RequestMapping("/staff")
public class StaffController{

    @Autowired
    private StaffService staffService;

    @ApiOperation(value="查询员工信息", notes="查询员工信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="ID", paramType="query", required = true, dataType="String"),
            @ApiImplicitParam(name="password",value="密码", paramType="query", required = true, dataType="String")
    })
    @PostMapping("/login")
    public IMoocJSONResult login(String id, String password){
        try {
            if(staffService.staffLogin(id,password)!=null){
                return IMoocJSONResult.ok(staffService.staffLogin(id,password));
            }
            else{
                return IMoocJSONResult.errorMsg("登录失败！");
            }
        } catch (Exception e) {
            return IMoocJSONResult.errorMsg("登录失败！");
        }
    }

    @ApiOperation(value="查询员工信息", notes="查询员工信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="ID", paramType="query",dataType="String"),
            @ApiImplicitParam(name="name",value="姓名", paramType="query",dataType="String"),
            @ApiImplicitParam(name="sex",value="性别", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="phone",value="电话", paramType="query",dataType="String"),
            @ApiImplicitParam(name="post",value="职务", paramType="query",dataType="String"),
            @ApiImplicitParam(name="role",value="角色", paramType="query",dataType="String")
    })
    @PostMapping("/query")
    public IMoocJSONResult query(String id,
                                 String name,
                                 Integer sex,
                                 String phone,
                                 String post,
                                 String role){
        try{
            List<Staff> result=staffService.queryStaffInfo(
                    id,
                    name,
                    sex,
                    phone,
                    post,
                    role);

            return IMoocJSONResult.ok(result);
        }catch (Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }
    }

    @ApiOperation(value="更新员工信息", notes="更新员工信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="ID", paramType="query",dataType="String"),
            @ApiImplicitParam(name="name",value="姓名", paramType="query",dataType="String"),
            @ApiImplicitParam(name="password",value="密码", paramType="query",dataType="String"),
            @ApiImplicitParam(name="sex",value="性别", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="phone",value="电话", paramType="query",dataType="String"),
            @ApiImplicitParam(name="post",value="职务", paramType="query",dataType="String")
    })
    @PostMapping("/update")
    public IMoocJSONResult update(String id,
                                  String name,
                                  String password,
                                  Integer sex,
                                  String phone,
                                  String post){
        try{
            // id只用于查询，不能被修改
            Staff staff = new Staff();
            staff.setId(id);
            staff.setName(name);
            staff.setPassword(password);
            staff.setSex(sex);
            staff.setPhone(phone);
            staff.setPost(post);
            staffService.updateStaffInfo(staff);
            return IMoocJSONResult.ok(staff);

        }catch (Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }
    }

    @ApiOperation(value="添加员工", notes="添加员工的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="名称", paramType="query",dataType="String", required = true),
            @ApiImplicitParam(name="password",value="密码", paramType="query",dataType="String", required = true),
            @ApiImplicitParam(name="sex",value="性别", required=true, paramType="query",dataType="int"),
            @ApiImplicitParam(name="phone",value="电话", paramType="query",dataType="String",required = true),
            @ApiImplicitParam(name="post",value="职务", paramType="query",dataType="String",required = true),
    })
    @PostMapping("/add")
    public IMoocJSONResult add(String name,
                               String password,
                               Integer sex,
                               String phone,
                               String post){

        try{

            Staff staff = new Staff();
            staff.setPassword(password);
            staff.setName(name);
            staff.setSex(sex);
            staff.setPhone(phone);
            staff.setPost(post);

            staffService.saveStaff(staff);

            return IMoocJSONResult.ok(staff);

        }catch (Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }


    }

    @ApiOperation(value="删除员工", notes="删除员工的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="ID", paramType="query",dataType="String", required = true),
    })
    @PostMapping("/delete")
    public IMoocJSONResult add(String id){

        try{
            staffService.deleteStaff(id);

            return IMoocJSONResult.ok();

        }catch (Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }
    }

    @ApiOperation(value="查询员工角色", notes="查询员工角色信息的接口")
    @ApiImplicitParam(name = "roleName",value = "角色名称", paramType = "query",dataType = "String", required = true)
    @PostMapping("/getStaffRoleList")
    public IMoocJSONResult getStaffRoleList(String roleName){
        try{
            List<StaffRoleVO> result = staffService.getStaffRoleList(roleName);
            return IMoocJSONResult.ok(result);
        }
        catch(Exception e){
            return IMoocJSONResult.errorMsg("查询失败！");
        }
    }

    @ApiOperation(value="更新员工角色", notes="更新员工角色信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hasRoleIds",value = "有角色的员工的ID（列表）", paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "noRoleIds",value = "无角色的员工的ID（列表）", paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "roleName",value = "角色名称", paramType = "query",dataType = "String", required = true)
    })
    @PostMapping("/setStaffRole")
    public IMoocJSONResult setStaffRole(String hasRoleIds, String noRoleIds, String roleName){
        try{
            List<String> ids_role = JsonUtils.jsonToList(hasRoleIds,String.class);
            List<String> ids_noRole = JsonUtils.jsonToList(noRoleIds, String.class);

            if (ids_role != null) {
                for (String id : ids_role) {
                    Staff staff = new Staff();
                    staff.setId(id);
                    staff.setRole(roleName);
                    staffService.updateStaffInfo(staff);
                }
            }

            if(ids_noRole != null){
                for (String id : ids_noRole) {
                    staffService.setRoleNull(id);
                }
            }


            return IMoocJSONResult.ok();
        }
        catch(Exception e){
            return IMoocJSONResult.errorMsg("操作失败！");
        }
    }

}

//try{
//
//        }catch (Exception e){
//        return IMoocJSONResult.errorMsg("查询失败！");
//        }
