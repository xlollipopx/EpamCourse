package com.epam.web.model;

public class Beat {
    private String name;
    private String timing;
    private String imagePath;
    private final int Id;
    private int albumId;
    private int accountId;
    private static IdGenerator idGenerator = new IdGenerator();

    public Beat(int Id, String name, String timing, String imagePath, int albumId, int accountId) {
        this.name = name;
        this.imagePath = imagePath;
        this.timing = timing;
        this.Id = Id;
        this.albumId = albumId;
        this.accountId = accountId;
    }

    public Beat( String name, String timing, String imagePath, int albumId, int accountId) {
        this.name = name;
        this.imagePath = imagePath;
        this.timing = timing;
        this.Id = idGenerator.generateId();
        this.albumId = albumId;
        this.accountId = accountId;
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

    public int getId() {
        return Id;
    }

    public String toString() {
        return name + " " + timing + " ";
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getAccountId() {
        return accountId;
    }
}
