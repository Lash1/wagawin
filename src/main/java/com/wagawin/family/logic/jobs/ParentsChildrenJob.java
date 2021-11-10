package com.wagawin.family.logic.jobs;

import com.wagawin.family.common.helper.ParentSummaryHelper;
import com.wagawin.family.model.entity.Person;
import com.wagawin.family.model.repository.ParentSummaryRepository;
import com.wagawin.family.model.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParentsChildrenJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentsChildrenJob.class);
    private final PersonRepository personRepository;
    private final ParentSummaryRepository parentSummaryRepository;

    public ParentsChildrenJob(PersonRepository personRepository, ParentSummaryRepository parentSummaryRepository) {
        this.personRepository = personRepository;
        this.parentSummaryRepository = parentSummaryRepository;
    }

    @Scheduled(cron = "0 0/15 * * * ?")
    public void updateParentChildren() {
        LOGGER.info("Starting to update parents summary data.");
        List<Person> people = personRepository.findAll();
        int maxNumOfChildren = ParentSummaryHelper.getMaxNumberOfChildren(people);
        if (maxNumOfChildren > 0) {
            int[] parentSummary = new int[maxNumOfChildren + 1];
            ParentSummaryHelper.fillParentsSummaryArray(parentSummary, people);
            //We can directly persist this array in a db table since it's already the required response object from the API, but since the task requirement asks for a ParentSummary
            //data structure I will create it.
            parentSummaryRepository.deleteAll();
            parentSummaryRepository.saveAll(ParentSummaryHelper.fromParentsSummaryArray(parentSummary));
        }
    }


}
