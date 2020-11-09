package com.springbootblog.controller;

import com.springbootblog.dto.PostDto;
import com.springbootblog.model.Post;
import com.springbootblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post/create")
    public ModelAndView showCreate() {
        return new ModelAndView("post/create", "post", new Post());
    }

    @PostMapping("/post/create")
    public String submitCreate(@Validated @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());

        postRepository.saveAndFlush(post);

        return "post/show";
    }

    @GetMapping("/post/edit")
    public ModelAndView showEdit(@RequestParam("postId") Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new RuntimeException("no post found" + postId);
        }

        return new ModelAndView("post/edit", "post", post);
    }

    @PostMapping("/post/edit")
    public String submitEdit(@Validated @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());

        postRepository.saveAndFlush(post);

        return "post/show";
    }

    @GetMapping("/post/show")
    public ModelAndView show(@RequestParam("postId") Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new RuntimeException("no post found" + postId);
        }

        return new ModelAndView("post/show", "post", new PostDto(post.get()));
    }

    @GetMapping("/post/delete")
    @ResponseBody
    public String delete(@RequestParam("postId") Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new RuntimeException("no post found" + postId);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", post.get().getId());
        postRepository.delete(post.get());
        jsonObject.put("success", true);
        return jsonObject.toString();
    }
}
