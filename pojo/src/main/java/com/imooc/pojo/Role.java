package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Role {
    @Id
    private String id;

    private String name;

    @Column(name = "create_time")
    private Integer createTime;

    @Column(name = "authorize_time")
    private Integer authorizeTime;

    private Integer status;

    private String operator;

    private String menus;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return create_time
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return authorize_time
     */
    public Integer getAuthorizeTime() {
        return authorizeTime;
    }

    /**
     * @param authorizeTime
     */
    public void setAuthorizeTime(Integer authorizeTime) {
        this.authorizeTime = authorizeTime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return menus
     */
    public String getMenus() {
        return menus;
    }

    /**
     * @param menus
     */
    public void setMenus(String menus) {
        this.menus = menus;
    }
}