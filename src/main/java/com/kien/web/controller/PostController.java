package com.kien.web.controller;

import com.kien.model.post.Post;
import com.kien.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/posts")
public class PostController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable Long id, Model ui) {
        Post post = postService.findById(id);
        ui.addAttribute("post",post);
        return "posts/view";
    }

}
