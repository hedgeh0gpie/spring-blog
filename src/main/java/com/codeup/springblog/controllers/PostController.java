package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostsRepository;
import com.codeup.springblog.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class PostController {

    private final PostsRepository postDao;
    private final UsersRepository userDao;

    public PostController(PostsRepository postDao, UsersRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String allTheAds(Model model) {

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    //    @GetMapping("/posts")
//    public String index(Model model) {
//
//
//        List<Post> postList = new ArrayList<>();
//        Post post2 = new Post("test title2", "test description2");
//        Post post3 = new Post("test title3", "test description3");
//
//        postList.add(post2);
//        postList.add(post3);
//
//        model.addAttribute("postList", postList);
//
//        return "posts/index";
//    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String specificPost(@PathVariable String id) {
//
//        return "view an individual post: " + id;
//    }

//    @GetMapping("/posts/edit/{id}")
//    public String editPostGET(@PathVariable long id, Model viewModel) {
//        viewModel.addAttribute("post", postDao.getById(id));
//        return "edit-oldway";
//    }
//
//    @PostMapping("/posts/edit/{id}")
//    public String editPostPOST(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam String body) {
//        Post post = postDao.getById(id);
//        post.setTitle(title);
//        post.setBody(body);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    //    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPostGET() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPostPOST() {
//        return "create a new post";
//    }
//    @GetMapping("/posts/create")
//    public String createPostGET() {
//        return "create-oldway";
//    }
//
//    @PostMapping("/posts/create")
//    public String createPostPOST(@RequestParam(name = "title") String title, @RequestParam String body) {
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(body);
//        post.setUser(userDao.getById(1L));
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @ModelAttribute("post") Post post) {
        post.setId(id);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePostPOST(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
