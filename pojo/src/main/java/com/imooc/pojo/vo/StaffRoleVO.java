package com.imooc.pojo.vo;

import com.imooc.pojo.Staff;

public class StaffRoleVO {

    private String staffId;

    private String staffName;

    private Integer status;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public StaffRoleVO(Staff staff, Boolean hasRole){
        if(hasRole){
            status = 1;
        }
        else{
            status = 0;
        }
        this.staffId = staff.getId();
        this.staffName = staff.getName();
    }
}
