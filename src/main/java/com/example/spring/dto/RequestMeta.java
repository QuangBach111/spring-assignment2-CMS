package com.example.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestMeta {
    private Long memberId;
    private String name;
    private String email;
    private String role;
}