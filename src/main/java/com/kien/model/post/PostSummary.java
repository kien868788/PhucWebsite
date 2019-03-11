package com.kien.model.post;

import java.util.Date;

public class PostSummary {
    private Long id;
    private String title;
    private Date dateOn;

    public PostSummary(Long id, String title, Date dateOn) {
        this.id = id;
        this.title = title;
        this.dateOn = dateOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOn() {
        return dateOn;
    }

    public void setDateOn(Date dateOn) {
        this.dateOn = dateOn;
    }
}
