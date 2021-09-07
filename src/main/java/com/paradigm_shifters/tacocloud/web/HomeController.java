package com.paradigm_shifters.tacocloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")        // Class level mapping
    public String home() {
        return "home";
    }
}