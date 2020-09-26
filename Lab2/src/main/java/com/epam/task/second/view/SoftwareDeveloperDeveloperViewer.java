package com.epam.task.second.view;

import com.epam.task.second.logic.SoftwareDeveloper;

public class SoftwareDeveloperDeveloperViewer implements DeveloperViewer {
    public void viewDeveloper(SoftwareDeveloper softwareDeveloper){
        System.out.println(softwareDeveloper.toString());
    }
}
