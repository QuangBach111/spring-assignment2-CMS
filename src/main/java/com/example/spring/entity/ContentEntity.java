package com.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="content_id",  updatable=false)
    private Long contentId;

    @Column(length=200, nullable=false)
    private String title;

    @Column(length=200, nullable=false)
    private String brief;

    @Column(length=200, nullable=false)
    private String content;

    @Column(name="created_date", length=200, nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdDate;

    @Column(name="updated_time", nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDate updatedTime;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;
}