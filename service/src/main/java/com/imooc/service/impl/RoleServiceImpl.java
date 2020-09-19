package com.imooc.service.impl;

import com.imooc.mapper.RoleMapper;
import com.imooc.mapper.StaffMapper;
import com.imooc.pojo.Role;
import com.imooc.pojo.Staff;
import com.imooc.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Role> queryRoleInfo(String id, String name) throws Exception {
        Example roleExample = new Example(Role.class);
        Example.Criteria criteria = roleExample.createCriteria();

        if(!StringUtils.isBlank(id)){
            criteria.andEqualTo("id", id);
        }
        if(!StringUtils.isBlank(name)){
            criteria.andEqualTo("name", name);
        }

        return roleMapper.selectByExample(roleExample);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveRole(Role role) throws Exception {
        String roleId = sid.nextShort();
        Integer time = (int) (System.currentTimeMillis() / 1000);
        role.setCreateTime(time);
        role.setId(roleId);
        roleMapper.insert(role);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void setPermission(Role role) throws Exception{
        Integer time = (int) (System.currentTimeMillis() / 1000);
        role.setAuthorizeTime(time);
        Example roleExample = new Example(Role.class);
        Example.Criteria criteria = roleExample.createCriteria();
        criteria.andEqualTo("id", role.getId());
        roleMapper.updateByExampleSelective(role, roleExample);
    }
}
