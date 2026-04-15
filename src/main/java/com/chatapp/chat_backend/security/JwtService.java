package com.chatapp.chat_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "mysecurejwtsecretkeymysecurejwtsecretkey";
    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    //--------------------- Generate JWT token -----------------------
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+864000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    //-------------------- Extract username from token ----------------------
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }
    //------------------------- Validate token -------------------------------
    public boolean isTokenValid(String token, UserDetails userDetails){
        return !extractAllClaims(token)
                .getExpiration().before(new Date());
    }
    //------------------------ Extract all claims ---------------------------
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}