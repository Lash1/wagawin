package com.wagawin.family.resource.dto;

import com.wagawin.family.common.enums.HouseType;
import com.wagawin.family.model.entity.House;

public class HouseDto {

    private String address;
    private String zipCode;
    private HouseType type;


    public static HouseDto fromHouse(House house) {
        if (house == null) {
            return new HouseDto();
        }
        HouseDto houseDto = new HouseDto();
        houseDto.setAddress(house.getAddress());
        houseDto.setType(house.getType());
        houseDto.setZipCode(house.getZipCode());
        return houseDto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public HouseType getType() {
        return type;
    }

    public void setType(HouseType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HouseDto{" +
                "address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", type=" + type +
                '}';
    }
}
