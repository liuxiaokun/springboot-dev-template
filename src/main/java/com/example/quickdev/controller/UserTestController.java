package com.example.quickdev.controller;

import com.example.quickdev.base.RL;
import com.example.quickdev.entity.UserTest;
import com.example.quickdev.service.UserTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/test")
public class UserTestController {

    private final UserTestService userTestService;

    public UserTestController(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @GetMapping("find/all")
    public RL<UserTest> findAll() {
        List<UserTest> list = userTestService.findAll();

        return RL.success(list);
    }
}
