package com.example.todo_list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafTestController {

    @GetMapping("/test-thymeleaf")
    public String testThymeleaf() {
        return "test";
    }
}