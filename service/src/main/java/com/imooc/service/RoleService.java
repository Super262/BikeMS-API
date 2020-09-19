package com.imooc.service;

import com.imooc.pojo.Role;
import net.sf.jsqlparser.statement.execute.Execute;

import java.util.List;

public interface RoleService {

    /**
     * @Description: 查询角色信息
     */
    public List<Role> queryRoleInfo(String id, String name) throws Exception;

    /**
     * @Description: 创建角色
     */
    public void saveRole(Role role) throws Exception;

    /**
     * @Description: 设置权限
     */
    public void setPermission(Role role) throws Exception;

}
