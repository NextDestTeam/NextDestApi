package com.happy.DTO;

import java.util.Date;

public class ActivityFilterDTO {
    private Integer price;
    private Integer activityTypeId;
    private String name;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
