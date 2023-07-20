package com.example.spring.interceptor;

import com.example.spring.dto.RequestMeta;
import com.example.spring.service.MemberService;
import com.example.spring.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@SessionAttributes("accessToken")
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get accessToken
        Object auth = request.getSession().getAttribute("accessToken");

        // If user not login
        if (auth == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        // verify accessToken
        Claims claims = jwtUtil.verify(auth.toString());

        RequestMeta requestMeta = new RequestMeta();

        requestMeta.setMemberId(Long.valueOf(claims.getIssuer()));
        requestMeta.setName(claims.get("firstName", String.class) + " " + claims.get("lastName", String.class));
        requestMeta.setEmail(claims.get("email", String.class));
        requestMeta.setRole(claims.get("role", String.class));

        request.setAttribute("requestMeta", requestMeta);
        return true;
    }
}