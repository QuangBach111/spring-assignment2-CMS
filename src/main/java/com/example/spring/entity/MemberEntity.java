package com.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="member_id", updatable=false)
    private Long memberId;

    @Column(name="first_name", length=100, nullable=false)
    private String firstName;

    @Column(name="last_name", length=100, nullable=false)
    private String lastName;

    @Column(name="password", length=100, nullable=false)
    private String password;

    @Column(name="phone", length=100, nullable=false, unique=true)
    private String phone;

    @Column(name="email", length=100, nullable=false, unique=true)
    private String email;

    private String description;

    @Column(length=5, nullable=false)
    private String role; //admin or user

    @Column(name="created_date", length=200, nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdDate;

    @Column(name="updated_time", nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDate updatedTime;

    @OneToMany(mappedBy="member")
    private List<ContentEntity> contents;
}