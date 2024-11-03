package com.feign_client.data.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {

    private final static String TOKEN_LOGIN = "9dh4up0e09Y5FT8Fj86BAnWtLY4crxgU";
    private final static Long TOKEN_SEGUNDOS = 1800L;

    public static String crearToken(String nombre, String email) {
        Date expiracionFecha = new Date(System.currentTimeMillis() + TOKEN_SEGUNDOS * 1000);

        Map<String, Object> map = new HashMap<>();
        map.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expiracionFecha)
                .addClaims(map)
                .signWith(Keys.hmacShaKeyFor(TOKEN_LOGIN.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(TOKEN_LOGIN.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            String nombre = claims.get("nombre", String.class);

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }

}
