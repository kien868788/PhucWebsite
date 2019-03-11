package com.kien.model.news;

public class NewsSummary {
    private Long id;
    private String title;
    private String dateOn;

    public NewsSummary(Long id, String title, String dateOn) {
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

    public String getDateOn() {
        return dateOn;
    }

    public void setDateOn(String dateOn) {
        this.dateOn = dateOn;
    }
}
