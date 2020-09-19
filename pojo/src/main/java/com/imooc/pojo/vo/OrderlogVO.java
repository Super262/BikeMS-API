package com.imooc.pojo.vo;

import com.imooc.pojo.Orderlog;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.Position;

import java.util.List;

public class OrderlogVO {
    private String id;

    private String city;

    private String bikeId;

    private String username;

    private String phone;

    private Float mileage;

    private Integer duration;

    private String status;

    private Integer startTime;

    private Integer finishTime;

    private Float standardCost;

    private Float actualCost;

    private List<Position> trace;

    public OrderlogVO(Orderlog raw){
        this.id=raw.getId();
        this.city=raw.getCity();
        this.bikeId=raw.getBikeId();
        this.username=raw.getUsername();
        this.phone=raw.getPhone();
        this.mileage=raw.getMileage();
        this.duration=raw.getDuration();
        this.status=raw.getStatus();
        this.startTime=raw.getStartTime();
        this.finishTime=raw.getFinishTime();
        this.standardCost=raw.getStandardCost();
        this.actualCost=raw.getActualCost();
        this.trace=JsonUtils.jsonToList(raw.getTrace(),Position.class);
    }

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
    public List<Position> getTrace() {
        return trace;
    }

    /**
     * @param trace
     */
    public void setTrace(List<Position> trace) {
        this.trace = trace;
    }
}
