package com.wagawin.family.resource.dto;

import com.wagawin.family.model.entity.Person;

public class ParentDto {

    private String name;
    private int age;
    private HouseDto house;


    public static ParentDto fromPerson(Person person){
        if(person == null){
            return new ParentDto();
        }
        ParentDto parentDto= new ParentDto();
        parentDto.setAge(person.getAge());
        parentDto.setHouse(HouseDto.fromHouse(person.getHouse()));
        parentDto.setName(person.getName());
        return parentDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HouseDto getHouse() {
        return house;
    }

    public void setHouse(HouseDto house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "ParentDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", house=" + house +
                '}';
    }
}
