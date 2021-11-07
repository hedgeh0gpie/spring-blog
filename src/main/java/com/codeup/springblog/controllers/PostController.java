package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model) {


        List<Post> postList = new ArrayList<>();
        Post post2 = new Post("test title2", "test description2");
        Post post3 = new Post("test title3", "test description3");

        postList.add(post2);
        postList.add(post3);

        model.addAttribute("postList", postList);

        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String individualPost(Model model) {
        Post post1 = new Post("test title1", "test description1");

        model.addAttribute("post", post1);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String specificPost(@PathVariable String id) {

        return "view an individual post: " + id;
    }




    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostGET() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostPOST() {
        return "create a new post";
    }


}
