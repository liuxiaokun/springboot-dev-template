package com.example.quickdev.controller;

import com.example.quickdev.base.RL;
import com.example.quickdev.base.RO;
import com.example.quickdev.base.RP;
import com.example.quickdev.controller.controller.BaseController;
import com.example.quickdev.dto.UserTestDTO;
import com.example.quickdev.exception.BizException;
import com.example.quickdev.service.UserTestService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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
        log.info("find all");
        List<UserTestDTO> list = userTestService.findAll();
        return RL.success(list);
    }

    @GetMapping("/page")
    public RP<UserTestDTO> findByPage(@RequestParam(defaultValue = "1") int p,
                                      @RequestParam(defaultValue = "10") int s) {
        log.info("list by page, pageNumber: {}, pageSize:{}", p, s);
        PageInfo<UserTestDTO> pageInfo = userTestService.findByPage(p, s, "password desc,id desc");
        return RP.success(pageInfo);
    }

    @GetMapping("/{id:\\d+}")
    public RO<UserTestDTO> findById(@PathVariable Long id) throws BizException {
        log.info("find by id:{}", id);
        Optional<UserTestDTO> dto = userTestService.findById(id);
        return RO.success(dto.orElseThrow(() -> new BizException("不存在的数据")));

    }

    @PostMapping
    public RO create(@RequestBody @Validated UserTestDTO dto, HttpServletRequest request) {
        log.info("create:{}", dto);
        fillCreateDTO(dto, request);
        boolean result = userTestService.save(dto);
        return result ? RO.success() : RO.fail();
    }

    @PostMapping("/batch")
    public RO batchCreate(@RequestBody List<UserTestDTO> dtos,
                          HttpServletRequest request) throws BizException {
        log.info("batch create:{}", dtos);
        dtos.stream().forEach(tem -> tem.setCreateBy(this.getUserId(request)));
        boolean result = userTestService.saveAll(dtos);
        return result ? RO.success() : RO.fail();
    }

    @PutMapping("/{id:\\d+}")
    public RO update(@RequestBody UserTestDTO dto, @PathVariable Long id,
                     HttpServletRequest request) {
        log.info("update:{}", dto);
        fillUpdateDTO(dto, request);
        dto.setId(id);
        boolean result = userTestService.updateById(dto);
        return result ? RO.success() : RO.fail();
    }

    @DeleteMapping("/{id:\\d+}")
    public RO deleteById(@PathVariable Long id) {
        log.info("delete by id:{}", id);
        boolean result = userTestService.deleteById(id);
        return result ? RO.success() : RO.fail();
    }
}
