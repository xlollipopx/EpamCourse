package view;

import model.Array;

public class ArrayConsoleViewer implements Viewer{
    public void view(Array array) {
        System.out.println(array.toString());
    }
}
