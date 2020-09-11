package com.example.quickdev.mapper;

import com.example.quickdev.entity.UserTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTestMapper {

    List<UserTest> selectAll();
}
