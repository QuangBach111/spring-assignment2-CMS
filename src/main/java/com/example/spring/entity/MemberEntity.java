package com.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="member_id", updatable=false)
    private Long memberId;

    @Column(name="first_name", length=100)
    private String firstName;

    @Column(name="last_name", length=100)
    private String lastName;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name="password", length=100, nullable=false)
    private String password;

    @Column(name="phone", length=100, unique=true)
    private String phone;

    @Column(name="email", length=100, nullable=false, unique=true)
    private String email;

    @Column(columnDefinition="varchar(10) DEFAULT 'USER'")
    private String role;

    private String description;

    @Column(name="created_date", length=200, nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdDate;

    @Column(name="updated_time", nullable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDate updatedTime;

    @OneToMany(mappedBy="member", fetch = FetchType.LAZY)
    private List<ContentEntity> contents;
}