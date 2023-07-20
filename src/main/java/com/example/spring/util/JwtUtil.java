package com.example.spring.util;

import com.example.spring.entity.MemberEntity;
import com.example.spring.exception.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static String secret = "This_is_secret";
    private static long expiryDuration = 5 * 60 * 60;

    public String generateJwt(MemberEntity memberEntity) {
        // Determine expire
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;
        Date issueAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // Claims
        Claims claims = Jwts.claims()
                            .setIssuer(memberEntity.getMemberId().toString())
                            .setIssuedAt(issueAt)
                            .setExpiration(expiryAt);
        claims.put("firstName", memberEntity.getFirstName());
        claims.put("lastName", memberEntity.getLastName());
        claims.put("email", memberEntity.getEmail());
        claims.put("role", memberEntity.getRole());

        return Jwts.builder().setClaims(claims)
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact();
    }

    public Claims verify(String authorization) throws UnauthorizedException {
        try {
            DefaultClaims claims = (DefaultClaims) Jwts.parser().setSigningKey(secret).parse(authorization).getBody();
            return claims;
        } catch (UnauthorizedException e) {
            throw new UnauthorizedException("Unauthorized");
        }
    }
}