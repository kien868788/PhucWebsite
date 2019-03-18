package com.kien.model.post;

import com.kien.model.CategorizedPost;
import com.kien.model.user.User;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {

    private Long id;

    @NotNull
    private String title;

    private Date dateOn;

    @NotNull
    private BigDecimal price;

    @NotNull
    private double square;

    private String description;

    private Tag tag;

    private User postedBy;

    private Set<CategorizedPost> categorizedPosts = new HashSet<>();

    public Post() {}

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSuperficies() {
        return square;
    }

    public void setSuperficies(double square) {
        this.square = square;
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

    public User getUser() {
        return postedBy;
    }

    public void setUser(User postedBy) {
        this.postedBy = postedBy;
    }

    public Set<CategorizedPost> getCategorizedPosts() {
        return categorizedPosts;
    }

    public void setCategorizedPosts(Set<CategorizedPost> categorizedPosts) {
        this.categorizedPosts = categorizedPosts;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
