package com.example.spring.service;

import com.example.spring.entity.ContentEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface ContentService {
    List<ContentEntity> getAllContents();
    ContentEntity getContentById(Long id);
    void createOrUpdateContent(ContentEntity content);
    void deleteContentById(Long id);

    Page<ContentEntity> findPaginated(int pageNo, int pageSize);
    List<ContentEntity> searchContentsByKeyword(String keyword);

    public void addContent(ContentEntity contentEntity);

    public void updateContent(ContentEntity contentEntity);

}