package com.imooc.pojo.vo;

import com.imooc.pojo.Bike;
import com.imooc.pojo.Bikelog;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.Position;

public class BikelogVO {
    private String id;

    private String city;

    private Integer time;

    private String bikeId;

    private Position position;

    public BikelogVO(String id, String city, Integer time, String bikeId, String position){
        this.id=id;
        this.city=city;
        this.time=time;
        this.bikeId=bikeId;
        this.position= JsonUtils.jsonToPojo(position, Position.class);
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(String position) {
        this.position= JsonUtils.jsonToPojo(position, Position.class);
    }
}
