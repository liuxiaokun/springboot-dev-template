package com.example.quickdev.service;

import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.entity.UserTest;
import com.github.pagehelper.PageInfo;

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
     * 分页查询列表
     *
     * @param pageNum  第几页
     * @param pageSize 一页几条
     * @param orderBy 排序，例如 "id desc, name asc"
     * @return PageInfo<UserTestDTO>
     */
    PageInfo<UserTestDTO> findByPage(int pageNum, int pageSize, String orderBy);

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
