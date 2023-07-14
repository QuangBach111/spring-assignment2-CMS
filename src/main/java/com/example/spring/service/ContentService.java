package com.example.spring.service;

import com.example.spring.entity.ContentEntity;

import java.util.List;
import java.util.Optional;

public interface ContentService {
    List<ContentEntity> getAllContents();
    Optional<ContentEntity> getContentById(Long id);
    void createOrUpdateContent(ContentEntity content);
    void deleteContentById(Long id);
    List<ContentEntity> searchContentsByKeyword(String keyword);
}