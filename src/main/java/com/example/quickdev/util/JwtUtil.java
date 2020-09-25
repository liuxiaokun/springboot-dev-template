package com.example.quickdev.util;

import com.example.quickdev.entity.UserTest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/22 15:40
 */
public class JwtUtil {

    /**
     * 主题
     */
    public static final String SUBJECT = "RookieLi";

    /**
     * 秘钥
     */
    public static final String SECRET_KEY = "Rookie666";

    /**
     * 过期时间, 毫秒，一周
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    /**
     * 生成JWT
     */
    public static String geneJsonWebToken(UserTest userTest) {

        if (userTest == null || userTest.getId() == null || userTest.getUsername() == null) {
            return null;
        }
        String token = Jwts.builder()
                .setSubject(SUBJECT)
                .claim("id", userTest.getId())
                .claim("name", userTest.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        return token;
    }


    /**
     * 校验JWT
     */
    public static Claims checkJWT(String token) {
        final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).
                parseClaimsJws(token).getBody();
        return claims;
    }
}