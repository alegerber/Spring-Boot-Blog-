package com.example.quickwindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @Autowired
    private MyFirstService myFirstService;

//    @GetMapping
//    public HelloDto hello() {
//        return new HelloDto("This Applications runs");
//    }

    @GetMapping
    public HelloDto hello(@RequestParam(required = false) String user) {
        return myFirstService.hello(user);
    }
}
