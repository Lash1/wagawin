package com.wagawin.family.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class Son extends Child{

    private String bicycleColor;


    public String getBicycleColor() {
        return bicycleColor;
    }

    public void setBicycleColor(String bicycleColor) {
        this.bicycleColor = bicycleColor;
    }

    @Override
    public String toString() {
        return "Son{" +
                "bicycleColor='" + bicycleColor + '\'' +
                '}';
    }
}
