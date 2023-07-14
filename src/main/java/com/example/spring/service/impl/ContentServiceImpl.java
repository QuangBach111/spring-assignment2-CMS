package com.example.spring.service.impl;

import com.example.spring.entity.ContentEntity;
import com.example.spring.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContentServiceImpl implements ContentService {
    @Override
    public List<ContentEntity> getAllContents() {
        return null;
    }

    @Override
    public Optional<ContentEntity> getContentById(Long id) {
        return Optional.empty();
    }

    @Override
    public void createOrUpdateContent(ContentEntity content) {

    }

    @Override
    public void deleteContentById(Long id) {

    }

    @Override
    public List<ContentEntity> searchContentsByKeyword(String keyword) {
        return null;
    }
}