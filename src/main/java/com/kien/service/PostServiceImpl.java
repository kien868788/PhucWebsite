package com.kien.service;

import com.kien.model.Category;
import com.kien.model.post.Post;
import com.kien.model.post.PostSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                "WHERE c.name =? ";
        return jdbcTemplate.query(sql,new Object[]{category.getName()},postSumaryRowMapper);
    }

    @Override
    public Page<PostSummary> findSumaryByCategoryAndPage(Pageable pageable) {
        return null;
    }

    @Override
    public Post findById(Long id) {
        String sql = "SELECT p.*, u.id AS user_id, u.firstName, u.lastName FROM posts p " +
                "INNER JOIN users u ON p.userId = u.id " +
                "INNER JOIN location lc ON lc.id = p.locationId " +
                "WHERE p.id =?";
        jdbcTemplate.query(sql,new Object[]{id}, rs -> {
            Post post = new Post();
            Map<Long,Post> map = new HashMap<>();
            while(rs.next()) {
                Long postId = rs.getLong("id");
                post = map.get(postId);
                if(post == null) {
                    post = new Post();
                    post.setId(postId);
                    post.setDateOn(rs.getDate("dateOn"));
                    post.setTitle(rs.getNString("title"));
                    post.setDescription(rs.getNString("description"));
                    post.setSquare(rs.getDouble("supercifies"));
                }
            }


            return post;
        });
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
