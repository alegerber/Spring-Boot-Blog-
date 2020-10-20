package com.springbootblog.controller;

import com.springbootblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/")
    @ResponseBody
    public String index() {
        return "Welcome to RestTemplate Example.";
    }

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("dto", blogService.home());
        return modelAndView;
    }
}
