package com.kien.model;

import com.kien.model.post.Post;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CategorizedPost {
    public static class Id implements Serializable {

        private Long categoryId;

        private Long postId;

        public Id() {}

        public Id(Long categoryId,Long postId) {
            this.categoryId = categoryId;
            this.postId = postId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return categoryId.equals(id.categoryId) &&
                    postId.equals(id.postId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryId, postId);
        }
    }

    private Id id = new Id();

    private String addedBy;

    private Date addedOn;

    private Category category;

    private Post post;

    public CategorizedPost(String addByUserName,
                           Category category,
                           Post post) {
        this.addedBy = addByUserName;
        this.category = category;
        this.post = post;
        this.id.categoryId = category.getId();
        this.id.postId = post.getId();

        category.getCategorizedPosts().add(this);
        post.getCategorizedPosts().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
