package com.example.spring.controller;

import com.example.spring.entity.ContentEntity;
import com.example.spring.repository.ContentRepository;
import com.example.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        ContentEntity content = contentService.getContentById(contentId);
        if (content != null) {
            model.addAttribute("content", content);
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

    private static final String REDIRECT_LOCATION = "redirect:/content/list/1";
    @GetMapping("/")
    public String home(Model model){
        return "layout/main";
    }
    @GetMapping("/add-content")
    public String addContent(Model model){
        model.addAttribute("content", new ContentEntity());
        return "content/content-add";
    }
    @PostMapping("/save-content")
    public String saveContent(@ModelAttribute ContentEntity contentEntity, BindingResult result, Model model){
        this.contentService.addContent(contentEntity);
        return REDIRECT_LOCATION;
    }
    @GetMapping("/show-form-update")
    public String showFormForUpdate(@RequestParam int contentId, Model model) {
        model.addAttribute("content", this.contentService.getContentById((long) contentId));
        return "content/content-edit";
    }
    @PostMapping("/update-content")
    public String doUpdateContent(@ModelAttribute ContentEntity contentEntity, BindingResult bindingResult, Model model){
        this.contentService.updateContent(contentEntity);
        return REDIRECT_LOCATION;
    }

    @GetMapping("/edit/{contentId}")
    public String showEditForm(@PathVariable("contentId") Long contentId, Model model) {
        ContentEntity content = contentService.getContentById(contentId);
        if (content != null) {
            model.addAttribute("content", content);
            return "content/content-edit";
        } else {
            return "redirect:/content/list/1";
        }
    }
}
//    @PostMapping("/update-content")
//    public String updateContent(@ModelAttribute ContentEntity contentEntity, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "content/content-edit";
//        }
//
//        contentService.updateContent(contentEntity);
//        return "redirect:/content/list/1";
//    }