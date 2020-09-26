package com.epam.task.second;

import com.epam.task.second.data.ConsoleDataAcquirer;
import com.epam.task.second.data.DataAcquirer;
import com.epam.task.second.logic.DeadlineCalculator;
import com.epam.task.second.logic.DeveloperCreator;
import com.epam.task.second.logic.SoftwareDeveloper;
import com.epam.task.second.view.DeadlineViewer;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataAcquirer dataAcquirer = new ConsoleDataAcquirer();
        DeadlineViewer deadlineViewer = new DeadlineViewer();
        DeadlineCalculator deadlineCalculator = new DeadlineCalculator();

        SoftwareDeveloper softwareDeveloper = dataAcquirer.getDeveloper();
        deadlineViewer.viewDeadline(deadlineCalculator.countDeadLineDate(softwareDeveloper));
    }

}
