package com.imooc.mapper;

import com.imooc.pojo.Staff;
import com.imooc.utils.MyMapper;
import org.springframework.stereotype.Component;

@Component
public interface StaffMapper extends MyMapper<Staff> {
    /**
     * @Description: 设置员工的角色为NULL
     */
    public void setRoleNull(String id);
}