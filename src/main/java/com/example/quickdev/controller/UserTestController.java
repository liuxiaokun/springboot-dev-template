package com.example.quickdev.controller;

import com.example.quickdev.base.RL;
import com.example.quickdev.base.RO;
import com.example.quickdev.base.RP;
import com.example.quickdev.controller.controller.BaseController;
import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.service.UserTestService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 10:12
 */
@Slf4j
@RestController
@RequestMapping("/user/test")
public class UserTestController extends BaseController<UserTestDTO> {

    private final UserTestService userTestService;

    public UserTestController(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @GetMapping()
    public RL<UserTestDTO> findAll() {
        List<UserTestDTO> list = userTestService.findAll();
        return RL.success(list);
    }

    @GetMapping("/page")
    public RP<UserTestDTO> findByPage(@RequestParam(defaultValue = "1") int p,
                                      @RequestParam(defaultValue = "10") int s) {
        PageInfo<UserTestDTO> pageInfo = userTestService.findByPage(p, s, "password desc,id desc");
        return RP.success(pageInfo);
    }

    @GetMapping("/{id}")
    public RO<UserTestDTO> findById(@PathVariable Long id) {
        UserTestDTO dto = userTestService.findById(id);
        return RO.success(dto);
    }

    @PostMapping
    public RO create(@RequestBody @Validated UserTestDTO dto, HttpServletRequest request) {
        fillDTO(dto, request);
        boolean result = userTestService.save(dto);
        return result ? RO.success() : RO.fail();
    }

    @PutMapping
    public RO update(@RequestBody UserTestDTO dto, HttpServletRequest request) {
        fillDTO(dto, request);
        boolean result = userTestService.updateById(dto);
        return result ? RO.success() : RO.fail();
    }

    @DeleteMapping("/{id}")
    public RO delete(@PathVariable Long id) {
        boolean result = userTestService.deleteById(id);
        return result ? RO.success() : RO.fail();
    }
}
