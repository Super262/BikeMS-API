package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class City {
    @Id
    private String id;

    private String name;

    @Column(name = "use_mode")
    private String useMode;

    @Column(name = "op_mode")
    private String opMode;

    private String leader;

    @Column(name = "op_time")
    private Integer opTime;

    private String operator;

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
     * @return use_mode
     */
    public String getUseMode() {
        return useMode;
    }

    /**
     * @param useMode
     */
    public void setUseMode(String useMode) {
        this.useMode = useMode;
    }

    /**
     * @return op_mode
     */
    public String getOpMode() {
        return opMode;
    }

    /**
     * @param opMode
     */
    public void setOpMode(String opMode) {
        this.opMode = opMode;
    }

    /**
     * @return leader
     */
    public String getLeader() {
        return leader;
    }

    /**
     * @param leader
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * @return op_time
     */
    public Integer getOpTime() {
        return opTime;
    }

    /**
     * @param opTime
     */
    public void setOpTime(Integer opTime) {
        this.opTime = opTime;
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
}