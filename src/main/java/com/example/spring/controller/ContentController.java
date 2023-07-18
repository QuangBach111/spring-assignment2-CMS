package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/content")
public class ContentController {
    @GetMapping("")
    public String list() {
        return "content/content-list";
    }
}