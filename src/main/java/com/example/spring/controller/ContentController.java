package com.example.spring.controller;

import com.example.spring.entity.ContentEntity;
import com.example.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "content-list";
    }

//    @GetMapping("/feature-type")
//    public String determineFeature(@RequestParam(value = "selectedContentIds", required = false) List<String> selectedContentIds,
//                                   @RequestParam("type") String type,
//                                   @RequestParam(value = "pageNo", required = false) String pageNo,
//                                   Model model) {
//        int pageNumber = 1;
//
//        if (selectedContentIds == null) {
//            return "redirect:/user/list/" + pageNo;
//        }
//        if (pageNo != null) {
//            pageNumber = Integer.parseInt(pageNo);
//        }
//
//        List<Long> contentIdCollection = selectedContentIds.stream()
//                .map(contentId -> Long.parseLong(contentId))
//                .collect(Collectors.toList());
//
//        if (type.equals("delete")) {
//            return deleteContent(contentIdCollection, pageNumber);
//        }
//
//        if (type.equals("disable")) {
//            return disableUser(userIdCollection, pageNumber);
//        }
//
//        return enableUser(userIdCollection, pageNumber);
//    }








}