package com.epam.web.model;

import java.sql.Date;

public class Comment {
    private String text;
    private int id;
    private int accountId;
    private int beatId;
    private Date date;
    private String authorName;

    public Comment(int id, String text, Date date, int accountId, int beatId ) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.accountId = accountId;
        this.beatId = beatId;
    }

    public Comment(String text, Date date, int accountId, int beatId ) {
        this.text = text;
        this.date = date;
        this.accountId = accountId;
        this.beatId = beatId;
    }


    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getBeatId() {
        return beatId;
    }

    public Date getDate() {
        return date;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }


}
