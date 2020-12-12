package com.epam.web.model;

public class Beat {
    private String name;
    private String timing;
    private String imagePath;
    private final int ID;
    private int authorId;

    public Beat(int ID, String name, String timing, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.timing = timing;
        this.ID = ID;
        //this.authorId = authorId;
    }

    public String getName() {
        return name;
    }



    public String getImagePath() {
        return imagePath;
    }

    public String getTiming() {
        return timing;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return name + " " + timing + " ";
    }

}
