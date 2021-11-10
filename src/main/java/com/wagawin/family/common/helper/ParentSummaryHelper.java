package com.wagawin.family.common.helper;

import com.wagawin.family.model.entity.ParentSummary;
import com.wagawin.family.model.entity.Person;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParentSummaryHelper {

    private ParentSummaryHelper() {
        throw new InaccessibleObjectException();
    }


    public static int getMaxNumberOfChildren(List<Person> people) {
        return people.stream()
                .map(Person::getChildren)
                .mapToInt(Set::size)
                .max()
                .orElse(0);
    }

    public static List<ParentSummary> fromParentsSummaryArray(int[] parentSummaryArray) {
        List<ParentSummary> parentSummaryList = new ArrayList<>();
        for (int i = 0; i < parentSummaryArray.length; i++) {
            ParentSummary parentSummary = new ParentSummary();
            parentSummary.setAmountOfPersons((long) parentSummaryArray[i]);
            parentSummary.setAmountOfChildren((long) i);
            parentSummaryList.add(parentSummary);
        }

        return parentSummaryList;
    }

    public static int[] toParentsSummaryArray(List<ParentSummary> parentSummaryList) {
        if (CollectionUtils.isEmpty(parentSummaryList)) {
            return new int[0];
        }
        int maxNumOfChildren = Math.toIntExact(parentSummaryList.stream()
                .map(ParentSummary::getAmountOfChildren)
                .max(Long::compareTo)
                .orElse(0L));
        int[] parentsSummaryArray = new int[maxNumOfChildren + 1];
        parentSummaryList.forEach(parentSummary -> parentsSummaryArray[Math.toIntExact(parentSummary.getAmountOfChildren())] = Math.toIntExact(parentSummary.getAmountOfPersons()));
        return parentsSummaryArray;
    }

    public static void fillParentsSummaryArray(int[] parentSummary, List<Person> people) {
        people.forEach(person -> {
            if (CollectionUtils.isEmpty(person.getChildren())) {
                parentSummary[0]++;
            } else {
                parentSummary[person.getChildren().size()]++;
            }
        });
    }
}
