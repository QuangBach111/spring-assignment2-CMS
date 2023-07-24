package com.example.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestMeta {
    private Long memberId;
    private String username;
    private String email;
    private String role;
}