package com.PlannerService.Planner.Service.impl;

import com.PlannerService.Planner.Service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService
{
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) // 시작 기간
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 만료기간
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    @Override
    public String generateRefreshToken(HashMap<String, Object> extraClaims, UserDetails userDetails)
    {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) // 시작 기간
                .setExpiration(new Date(System.currentTimeMillis() + 604800000)) // 만료기간 7일
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Key getSiginKey() {
        byte[] key = Decoders.BASE64.decode("96021eb6fcc922632cb0bc7c46f931a39387cc541af0e06838efbc3e3eb53a73bb5c00f8496318ac5cfeaea51030baa037679750b1c3a012f1a1c08f76f6ffa2");
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSiginKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
