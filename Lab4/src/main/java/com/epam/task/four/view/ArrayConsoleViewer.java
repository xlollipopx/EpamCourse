package com.epam.task.four.view;


import com.epam.task.four.model.Array;

public class ArrayConsoleViewer implements Viewer {
    public void view(Array array) {
        System.out.println(array.toString());
    }
}
