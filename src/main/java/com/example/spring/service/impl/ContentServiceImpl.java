package com.example.spring.service.impl;

import com.example.spring.entity.ContentEntity;
import com.example.spring.repository.ContentRepository;
import com.example.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;
    @Override
    public List<ContentEntity> getAllContents() {
        return this.contentRepository.findAll();
    }

    @Override
    public ContentEntity getContentById(Long id) {
        Optional<ContentEntity> optionalContent= this.contentRepository.findById(id);
        if(optionalContent.isPresent())
            return  optionalContent.get();
        return new ContentEntity();
    }


    @Override
    public void createOrUpdateContent(ContentEntity content) {
        this.contentRepository.save(content);
    }

    @Override
    public void deleteContentById(Long id) {
        this.contentRepository.deleteById(id);
    }


    @Override
    public Page<ContentEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return contentRepository.findAll(pageable);
    }


    @Override
    public List<ContentEntity> searchContentsByKeyword(String keyword) {
        return contentRepository.findByKeyword(keyword);
    }
    @Override
    public void addContent(ContentEntity contentEntity) {
        contentRepository.save(contentEntity);
    }

    @Override
    public void updateContent(ContentEntity contentEntity) {
        contentRepository.save(contentEntity);
    }


}

