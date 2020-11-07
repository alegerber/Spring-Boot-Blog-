package com.springbootblog.controller;

import com.springbootblog.model.Post;
import com.springbootblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/post/create")
    public ModelAndView showCreate() {
        return new ModelAndView("post/create", "post", new Post());
    }

    @PostMapping(value = "/post/create")
    public String submitCreate(@Validated @ModelAttribute("post")Post post, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());

        return "post/create";
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView("home");
        //modelAndView.addObject("dto", blogService.home());
        return modelAndView;
    }

    @GetMapping(value = "/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("home");
        //modelAndView.addObject("dto", blogService.home());
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(Post post) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", post.getId());
        postRepository.delete(post);
        jsonObject.put("success", true);
        return jsonObject.toString();
    }
}
