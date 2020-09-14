package com.example.quickdev.service;

import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;

import java.util.List;

/**
 * @author liuxiaokun
 */
public interface UserTestService {

    /**
     * 查询列表
     *
     * @return List<UserTestDTO>
     */
    List<UserTestDTO> findAll();

    /**
     * 根据ID查询
     *
     * @param id id
     * @return UserTestDTO
     */
    UserTestDTO findById(Long id);

    /**
     * 保存多条
     *
     * @param dtos dto
     * @return boolean
     */
    boolean saveAll(List<UserTestDTO> dtos);
}
