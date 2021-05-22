package com.epam.web.model;

public class Beat {
    private String name;
    private String audioPath;
    private String imagePath;
    private final int id;
    private int albumId;
    private int accountId;
    private static IdGenerator idGenerator = new IdGenerator();

    public Beat(int Id, String name, String audioPath, String imagePath, int albumId, int accountId) {
        this.name = name;
        this.imagePath = imagePath;
        this.audioPath = audioPath;
        this.id = Id;
        this.albumId = albumId;
        this.accountId = accountId;
    }

    public Beat(String name, String audioPath, String imagePath, int albumId, int accountId) {
        this.name = name;
        this.imagePath = imagePath;
        this.audioPath = audioPath;
        this.id = idGenerator.generateId();
        this.albumId = albumId;
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }



    public String getImagePath() {
        return imagePath;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name + " " ;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getAccountId() {
        return accountId;
    }

}
