package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Bikelog {
    @Id
    private String id;

    private Integer time;

    @Column(name = "bike_id")
    private String bikeId;

    private String position;

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
     * @return time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Integer time) {
        this.time = time;
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
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }
}