package com.wagawin.family.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="child_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="child_type", insertable=false, updatable=false)
    private Integer type;


    @Column
    private String name;

    @Column
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;


    @OneToMany(mappedBy = "child")
    private List<Meal> meals;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", person=" + person +
                ", meals=" + meals +
                '}';
    }


}
