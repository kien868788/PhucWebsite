package com.kien.model.post;

import java.math.BigDecimal;
import java.util.Date;

public class PostSummary {
    private Long id;
    private String title;
    private Date dateOn;
    private BigDecimal price;
    private double superficies;

    public PostSummary() {}

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSuperficies() {
        return superficies;
    }

    public void setSuperficies(double superficies) {
        this.superficies = superficies;
    }
}
