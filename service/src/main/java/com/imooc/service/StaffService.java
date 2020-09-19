package com.imooc.service;

import com.imooc.pojo.Staff;
import com.imooc.pojo.vo.StaffRoleVO;

import java.util.List;

public interface StaffService {

    /**
     * @Description: 查询员工信息
     */
    public List<Staff> queryStaffInfo(String id,
                                      String name,
                                      Integer sex,
                                      String phone,
                                      String post,
                                      String role) throws Exception;
    /**
     * @Description: 员工登录
     */
    public Staff staffLogin(String id, String password) throws Exception;


    /**
     * @Description: 修改员工信息
     */
    public void updateStaffInfo(Staff staff) throws Exception;

    /**
     * @Description: 添加员工
     */
    public void saveStaff(Staff staff) throws Exception;

    /**
     * @Description: 删除员工
     */
    public void deleteStaff(String id) throws Exception;

    /**
     * @Description: 设置员工角色为NULL
     */
    public void setRoleNull(String id) throws Exception;

    /**
     * @Description: 查询用户列表；status = 1，拥有当前角色；status = 0 没有角色
     */
    public List<StaffRoleVO> getStaffRoleList(String roleName) throws Exception;
}
