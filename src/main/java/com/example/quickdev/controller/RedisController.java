package com.example.quickdev.controller;

import com.example.quickdev.entity.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author liuxiaokun
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("test")
    public String test() {
        UserTest userTest = new UserTest();
        userTest.setCreateDate(new Date());

        redisTemplate.opsForValue().set("test-111", "test-111-value");
        redisTemplate.opsForValue().set("test-111-entity", userTest);

        redisTemplate.opsForHash().put("hash-test", "aa", "bb");
        redisTemplate.opsForHash().put("hash-test", "aaa", userTest);

        return "success";
    }
}
