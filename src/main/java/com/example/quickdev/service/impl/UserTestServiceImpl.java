package com.example.quickdev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;
import com.example.quickdev.exception.BizException;
import com.example.quickdev.mapper.UserTestMapper;
import com.example.quickdev.service.UserTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
        List<UserTest> userTests = userTestMapper.selectList(new QueryWrapper<>());

        return userTests.stream().map(userTest -> {
            UserTestDTO dto = new UserTestDTO();
            BeanUtils.copyProperties(userTest, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserTestDTO findById(Serializable id) {
        UserTest userTest = userTestMapper.selectById(id);
        UserTestDTO dto = new UserTestDTO();
        BeanUtils.copyProperties(userTest, dto);
        return dto;
    }

    @Override
    public boolean save(UserTestDTO dto) {
        UserTest userTest = new UserTest();
        BeanUtils.copyProperties(dto, userTest);
        int rows = userTestMapper.insert(userTest);
        return rows == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveAll(List<UserTestDTO> dtos) {

        dtos.forEach(tem -> {
            UserTest userTest = new UserTest();
            BeanUtils.copyProperties(tem, userTest);
            int rows = userTestMapper.insert(userTest);
            if (rows != 1) {
                throw new BizException("Batch insert failed， Rollback");
            }
        });
        return true;
    }
}
