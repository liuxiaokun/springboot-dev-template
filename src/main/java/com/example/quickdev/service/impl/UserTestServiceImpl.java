package com.example.quickdev.service.impl;

import com.example.quickdev.entity.UserTest;
import com.example.quickdev.mapper.UserTestMapper;
import com.example.quickdev.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxiaokun
 */
@Service
public class UserTestServiceImpl implements UserTestService {

    private final UserTestMapper userTestMapper;

    public UserTestServiceImpl(UserTestMapper userTestMapper) {
        this.userTestMapper = userTestMapper;
    }

    @Override
    public List<UserTest> findAll() {
        return userTestMapper.selectAll();
    }
}
