package com.example.quickdev.controller.controller;

import com.example.quickdev.dto.base.BaseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 15:16
 */
@Component
public class BaseController<T extends BaseDTO> {

    @Value("${jwt.signKey}")
    private String signKey;

    protected void fillCreateDTO(T t, HttpServletRequest request) {
        t.setCreateBy(getUserId(request));
    }

    protected void fillUpdateDTO(T t, HttpServletRequest request) {
        t.setModifyBy(getUserId(request));
    }

    protected Long getUserId(HttpServletRequest request) {
        /*String jwt = request.getHeader("Authorization");

        Claims claims = Jwts.parser()
                .setSigningKey(signKey.getBytes())
                .parseClaimsJws(jwt.replace("Bearer ", ""))
                .getBody();
        return Long.parseLong(claims.getSubject());*/
        return 1L;
    }

    protected String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
