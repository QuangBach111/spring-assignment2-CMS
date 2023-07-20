package com.example.spring.interceptor;

import com.example.spring.dto.RequestMeta;
import com.example.spring.exception.UnauthorizedException;
import com.example.spring.util.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestMeta requestMeta = (RequestMeta) request.getAttribute("requestMeta");

        if (!Constant.ROLE_USER.equals(requestMeta.getRole())) {
            throw new UnauthorizedException("Unauthorized");
        }

        return true;
    }
}