package com.example.quickdev.service.impl;

import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;
import com.example.quickdev.mapper.UserTestMapper;
import com.example.quickdev.service.UserTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserTestDTO> findAll() {
        List<UserTest> userTests = userTestMapper.selectAll();

        return userTests.stream().map(userTest -> {
            UserTestDTO dto = new UserTestDTO();
            BeanUtils.copyProperties(userTest, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserTestDTO findById(Long id) {
        UserTest userTest = userTestMapper.selectById(id);
        UserTestDTO dto = new UserTestDTO();
        BeanUtils.copyProperties(userTest, dto);
        return dto;
    }

    @Override
    public boolean saveAll(List<UserTestDTO> dtos) {
        return false;
    }
}
