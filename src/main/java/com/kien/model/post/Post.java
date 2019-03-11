package com.kien.model.post;

import com.kien.model.user.User;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class Post {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String localtion;

    private Date dateOn;

    @NotNull
    private BigDecimal price;

    private String description;

    private Tag tag;

    private User user;

    public Post() {}

    public Post(@NotNull String title, @NotNull String localtion, @NotNull BigDecimal price,User user) {
        this.title = title;
        this.localtion = localtion;
        this.price = price;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
