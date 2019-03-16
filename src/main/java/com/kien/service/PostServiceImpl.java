package com.kien.service;

import com.kien.model.Category;
import com.kien.model.post.Post;
import com.kien.model.post.PostSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService{

    private JdbcTemplate jdbcTemplate;

    private RowMapper<PostSummary>  postSumaryRowMapper = (rs, rowNum) -> {
        PostSummary postSummary = new PostSummary();
        postSummary.setTitle(rs.getString("title"));
        postSummary.setDateOn(rs.getDate("dateOn"));
        postSummary.setId(rs.getLong("id"));
        postSummary.setSuperficies(rs.getDouble("superficies"));
        postSummary.setPrice(rs.getBigDecimal("price"));
        return postSummary;
    };

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PostSummary> findAllSumary() {
        String sql = "SELECT id,dateOn,superficies,title,dateOn FROM post";
        return jdbcTemplate.query(sql,postSumaryRowMapper);
    }


    @Override
    public List<PostSummary> findSumaryByCategory(Category category) {
        String sql = "SELECT p.id,p.dateOn,p.superficies,p.title,p.dateOn FROM post p " +
                "INNER JOIN category_post cp ON p.id = cp.post_id " +
                "INNER JOIN category c ON cp.category_id = c.category_id " +
                "WHERE c.name = " + category.getName();
        return jdbcTemplate.query(sql,postSumaryRowMapper);
    }

    @Override
    public Page<Post> findSumaryByCategoryAndPage(Pageable pageable) {
        return null;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }


    @Override
    public void insert(Post post) {
    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(Long postId) {

    }




}
