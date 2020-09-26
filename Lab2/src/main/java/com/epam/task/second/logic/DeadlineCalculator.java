package com.epam.task.second.logic;

import java.util.Calendar;

public class DeadlineCalculator {
    private Calendar deadlineDate = Calendar.getInstance();

    public String countDeadLineDate(SoftwareDeveloper softwareDeveloper) {
        deadlineDate.add(Calendar.DAY_OF_MONTH, softwareDeveloper.getDaysRequired());
        return deadlineDate.getTime().toString();
    }

}
