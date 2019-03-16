package com.kien.service;

import com.kien.model.Category;
import com.kien.model.post.Post;
import com.kien.model.post.PostSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<PostSummary> findAllSumary();
    List<PostSummary> findSumaryByCategory(Category category);
    Page<Post> findSumaryByCategoryAndPage(Pageable pageable);

    Post findById(Long id);

    void insert(Post post);
    void update(Post post);
    void delete(Long postId);
}
