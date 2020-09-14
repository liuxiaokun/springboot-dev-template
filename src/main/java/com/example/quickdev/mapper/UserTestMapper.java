package com.example.quickdev.mapper;

import com.example.quickdev.entity.UserTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTestMapper {

    List<UserTest> selectAll();

    /**
     * 根据id查询一条数据
     * @param id id
     * @return UserTest
     */
    UserTest selectById(Long id);

    int insertAll(List<UserTest> data);
}
