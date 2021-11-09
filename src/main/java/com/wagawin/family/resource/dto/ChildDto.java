package com.wagawin.family.resource.dto;

import com.wagawin.family.model.entity.Child;
import com.wagawin.family.model.entity.Meal;
import org.springframework.util.CollectionUtils;

public class ChildDto {

    private ParentDto parent;
    private Meal favoriteMeal;


    public static ChildDto fromChild(Child child) {
        if (child == null) {
            return new ChildDto();
        }
        ChildDto childDto = new ChildDto();
        childDto.setParent(ParentDto.fromPerson(child.getPerson()));
        if (!CollectionUtils.isEmpty(child.getMeals())) {
            childDto.setFavoriteMeal(child.getMeals().get(0));
        }
        return childDto;
    }

    public ParentDto getParent() {
        return parent;
    }

    public void setParent(ParentDto parent) {
        this.parent = parent;
    }

    public Meal getFavoriteMeal() {
        return favoriteMeal;
    }

    public void setFavoriteMeal(Meal favoriteMeal) {
        this.favoriteMeal = favoriteMeal;
    }

    @Override
    public String toString() {
        return "ChildDto{" +
                "parent=" + parent +
                ", favoriteMeal=" + favoriteMeal +
                '}';
    }
}
