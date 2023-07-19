package com.example.spring.controller;

import com.example.spring.entity.ContentEntity;
import com.example.spring.repository.ContentRepository;
import com.example.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;
    @Autowired
    private ContentRepository contentRepository;

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
    public String deleteContent(@RequestParam(value = "selectedContentIds", required = false) List<Long> contentIds) {
        if (contentIds != null && !contentIds.isEmpty()) {
            for (Long contentId : contentIds) {
                contentService.deleteContentById(contentId);
            }
        }
        return "redirect:/content/list/1";
    }


    @GetMapping("/view/{contentId}")
    public String viewContent(@PathVariable("contentId") Long contentId, Model model) {
        Optional<ContentEntity> content = contentService.getContentById(contentId);
        if (content.isPresent()) {
            model.addAttribute("content", content.get());
            return "content/content-view";
        } else {
            return "redirect:/content/list/1";
        }
    }





    @GetMapping("/search")
    public String searchContent(@RequestParam("keyword") String keyword, Model model) {
        List<ContentEntity> searchResults;
        if (keyword.isEmpty()) {
            searchResults = contentService.getAllContents();
        } else {
            searchResults = contentService.searchContentsByKeyword(keyword);
        }
        model.addAttribute("contents", searchResults);
        return "content/content-search";
    }






    }
