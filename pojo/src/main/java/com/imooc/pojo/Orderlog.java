package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Orderlog {
    @Id
    private String id;

    private String city;

    @Column(name = "bike_id")
    private String bikeId;

    private String username;

    private String phone;

    private Float mileage;

    private Integer duration;

    private String status;

    @Column(name = "start_time")
    private Integer startTime;

    @Column(name = "finish_time")
    private Integer finishTime;

    @Column(name = "standard_cost")
    private Float standardCost;

    @Column(name = "actual_cost")
    private Float actualCost;

    private String trace;

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
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return bike_id
     */
    public String getBikeId() {
        return bikeId;
    }

    /**
     * @param bikeId
     */
    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return mileage
     */
    public Float getMileage() {
        return mileage;
    }

    /**
     * @param mileage
     */
    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    /**
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return start_time
     */
    public Integer getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    /**
     * @return finish_time
     */
    public Integer getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime
     */
    public void setFinishTime(Integer finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * @return standard_cost
     */
    public Float getStandardCost() {
        return standardCost;
    }

    /**
     * @param standardCost
     */
    public void setStandardCost(Float standardCost) {
        this.standardCost = standardCost;
    }

    /**
     * @return actual_cost
     */
    public Float getActualCost() {
        return actualCost;
    }

    /**
     * @param actualCost
     */
    public void setActualCost(Float actualCost) {
        this.actualCost = actualCost;
    }

    /**
     * @return trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * @param trace
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }
}