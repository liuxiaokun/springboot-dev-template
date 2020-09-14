package com.example.quickdev.service;

import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;

import java.io.Serializable;
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
    UserTestDTO findById(Serializable id);

    /**
     * 保存一条
     *
     * @param dto dto
     * @return boolean
     */
    boolean save(UserTestDTO dto);

    /**
     * 保存多条
     *
     * @param dtos dto
     * @return boolean
     */
    boolean saveAll(List<UserTestDTO> dtos);
}
