package com.example.quickdev.controller;

import com.example.quickdev.base.RL;
import com.example.quickdev.base.RO;
import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.service.UserTestService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 10:12
 */
@RestController
@RequestMapping("/user/test")
public class UserTestController {

    private final UserTestService userTestService;

    public UserTestController(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @GetMapping("")
    public RL<UserTestDTO> findAll() {
        List<UserTestDTO> list = userTestService.findAll();
        return RL.success(list);
    }

    @GetMapping("/{id}")
    public RO<UserTestDTO> findById(@PathVariable Long id) {
        UserTestDTO dto = userTestService.findById(id);
        return RO.success(dto);
    }

    @PostMapping("")
    public RO add(@RequestBody UserTestDTO dto) {
        dto.setCreateDate(new Date());
        dto.setCreateBy(520L);
        dto.setModifyBy(520L);
        dto.setStatus(1);
        boolean result = userTestService.save(dto);
        return result ? RO.success() : RO.fail();
    }
}
