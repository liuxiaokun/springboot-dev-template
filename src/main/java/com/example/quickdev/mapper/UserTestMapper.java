package com.example.quickdev.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.quickdev.entity.UserTest;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespaceRef(UserTestMapper.class)
public interface UserTestMapper extends BaseMapper<UserTest> {
}
