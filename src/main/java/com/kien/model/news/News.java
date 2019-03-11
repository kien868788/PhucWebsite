package com.kien.model.news;

import com.kien.model.user.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{

    private Long id;

    @NotNull
    private String title;

    private String content;

    private Date dateOn;

    private User user;

    public News() {}

    public News(String title,String content,User user) {
        this.title = title;
        this.content = content;
        this.user = user;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOn() {
        return dateOn;
    }

    public void setDateOn(Date dateOn) {
        this.dateOn = dateOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
