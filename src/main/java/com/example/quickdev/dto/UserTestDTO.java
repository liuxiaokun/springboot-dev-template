package com.example.quickdev.dto;

import com.example.quickdev.dto.base.BaseDTO;
import com.example.quickdev.entity.base.BaseEntity;
import com.example.quickdev.enums.GenderEnum;
import lombok.Data;

/**
 * @author liuxiaokun
 */
@Data
public class UserTestDTO extends BaseDTO {

    private String username;
    private String password;
    private GenderEnum gender;
}
