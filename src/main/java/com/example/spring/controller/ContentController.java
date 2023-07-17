package com.example.spring.controller;

import com.example.spring.entity.ContentEntity;
import com.example.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/list/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo,
                                Model model) {
        int pageSize = 5;

        Page<ContentEntity> page = this.contentService.findPaginated(pageNo, pageSize);
        List<ContentEntity> contents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("items", page.getTotalElements());
        model.addAttribute("contents", contents);
        return "content/content-list";
    }
    @PostMapping("/delete")
    @DeleteMapping("/delete")
    public String deleteContent(@RequestParam("selectedContentIds") List<Long> contentIds) {
        for (Long contentId : contentIds) {
            contentService.deleteContentById(contentId);
        }
        return "redirect:/content/list/1";
    }





}
