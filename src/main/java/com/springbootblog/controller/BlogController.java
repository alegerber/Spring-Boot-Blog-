package com.springbootblog.controller;

import com.springbootblog.service.MyFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private MyFirstService myFirstService;

    @GetMapping(value = "/")
    public ModelAndView home(@RequestParam(required = false) String userName) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("dto", myFirstService.hello(userName));
        return modelAndView;
    }
}
