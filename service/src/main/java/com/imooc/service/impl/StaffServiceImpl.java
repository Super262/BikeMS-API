package com.imooc.service.impl;

import com.imooc.mapper.StaffMapper;
import com.imooc.pojo.Staff;
import com.imooc.pojo.vo.StaffRoleVO;
import com.imooc.service.StaffService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private Sid sid;

    @Autowired
    private StaffMapper staffMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Staff> queryStaffInfo(String id,String name,Integer sex,String phone,String post,String role) throws Exception{

        Example staffExample = new Example(Staff.class);
        Example.Criteria criteria = staffExample.createCriteria();

        if(!StringUtils.isBlank(id)){
            criteria.andEqualTo("id", id);
        }

        if(!StringUtils.isBlank(name)) {
            criteria.andEqualTo("name",name);
        }

        if(sex.compareTo(-1)!=0){
            criteria.andEqualTo("sex", sex);
        }

        if(!StringUtils.isBlank(phone)){
            criteria.andEqualTo("phone", phone);
        }

        if(!StringUtils.isBlank(post)){
            criteria.andEqualTo("post", post);
        }

        if(!StringUtils.isBlank(role)){
            criteria.andEqualTo("role", role);
        }

        return staffMapper.selectByExample(staffExample);
    }

    @Override
    public Staff staffLogin(String id,String password) throws Exception {
        if(StringUtils.isBlank(id) || StringUtils.isBlank(password)){
            throw new Exception();
        }
        Example staffExample = new Example(Staff.class);
        Example.Criteria criteria = staffExample.createCriteria();
        criteria.andEqualTo("id",id);
        criteria.andEqualTo("password",password);
        return staffMapper.selectOneByExample(staffExample);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStaffInfo(Staff staff) throws Exception{
        Example staffExample = new Example(Staff.class);
        Example.Criteria criteria = staffExample.createCriteria();
        criteria.andEqualTo("id", staff.getId());
        staffMapper.updateByExampleSelective(staff, staffExample);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStaff(Staff staff) throws Exception{
        String staffId = sid.nextShort();
        staff.setId(staffId);
        staffMapper.insert(staff);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStaff(String id) throws Exception{
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        staffMapper.deleteByExample(example);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void setRoleNull(String id) throws Exception {
        staffMapper.setRoleNull(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<StaffRoleVO> getStaffRoleList(String roleName) throws Exception {
        Example noRoleExample = new Example(Staff.class);
        Example.Criteria noRoleCriteria = noRoleExample.createCriteria();
        noRoleCriteria.andIsNull("role");
        List<Staff> noRoleList = staffMapper.selectByExample(noRoleExample);

        Example hasRoleExample = new Example(Staff.class);
        Example.Criteria hasRoleCriteria = hasRoleExample.createCriteria();
        hasRoleCriteria.andEqualTo("role", roleName);
        List<Staff> hasRoleList = staffMapper.selectByExample(hasRoleExample);

        List<StaffRoleVO> resultList = new ArrayList<>();

        if(noRoleList.size()!=0 || hasRoleList.size()!=0){

            for (Staff staff : noRoleList) {
                StaffRoleVO staffRoleVO = new StaffRoleVO(staff,false);
                resultList.add(staffRoleVO);
            }

            for (Staff staff : hasRoleList) {
                StaffRoleVO staffRoleVO = new StaffRoleVO(staff,true);
                resultList.add(staffRoleVO);
            }

            return resultList;
        }
        else{
            throw new Exception();
        }
    }
}
