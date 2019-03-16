package com.kien.model;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private Long id;

    private String name;

    private Set<CategorizedPost> categorizedPosts = new HashSet<>();

    private Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategorizedPost> getCategorizedPosts() {
        return categorizedPosts;
    }

    public void setCategorizedPosts(Set<CategorizedPost> categorizedPosts) {
        this.categorizedPosts = categorizedPosts;
    }

}
