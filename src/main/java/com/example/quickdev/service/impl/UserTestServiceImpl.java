package com.example.quickdev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;
import com.example.quickdev.exception.BizException;
import com.example.quickdev.mapper.UserTestMapper;
import com.example.quickdev.service.UserTestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
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
    public PageInfo<UserTestDTO> findByPage(int pageNum, int pageSize, String orderBy) {
        //orderBy 写字段名而不是成员名，多个逗号分隔，例如 "id desc,name asc"
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<UserTest> userTests = userTestMapper.selectList(new QueryWrapper<>());

        return new PageInfo<>(userTests.stream().map(userTest -> {
            UserTestDTO dto = new UserTestDTO();
            BeanUtils.copyProperties(userTest, dto);
            return dto;
        }).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserTestDTO> findById(Serializable id) {
        UserTest userTest = userTestMapper.selectById(id);

        if (null == userTest) {
            return Optional.empty();
        }
        UserTestDTO dto = new UserTestDTO();
        BeanUtils.copyProperties(userTest, dto);
        return Optional.of(dto);
    }

    @Override
    public boolean save(UserTestDTO dto) {
        UserTest userTest = new UserTest();
        BeanUtils.copyProperties(dto, userTest);
        int rows = userTestMapper.insert(userTest);
        return rows == 1;
    }

    @Override
    public boolean updateById(UserTestDTO dto) {
        UserTest userTest = new UserTest();
        BeanUtils.copyProperties(dto, userTest);
        int rows = userTestMapper.updateById(userTest);
        return rows == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveAll(List<UserTestDTO> dtos) throws BizException {
        for (UserTestDTO tem : dtos) {
            UserTest userTest = new UserTest();
            BeanUtils.copyProperties(tem, userTest);
            int rows = userTestMapper.insert(userTest);
            if (rows != 1) {
                throw new BizException("Batch insert failed， Rollback");
            }
        }
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {
        int rows = userTestMapper.deleteById(id);
        return rows == 1;
    }
}
