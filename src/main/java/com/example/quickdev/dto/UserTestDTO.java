package com.example.quickdev.dto;

import com.example.quickdev.dto.base.BaseDTO;
import com.example.quickdev.enums.GenderEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liuxiaokun
 */
@Data
public class UserTestDTO extends BaseDTO {


    @NotBlank(message = "用户名不能为空")
    @Length(min = 4, max = 8, message = "用户名长度应为4~8位")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8, message = "密码不足8位")
    private String password;

    @NotNull(message = "姓名不能为空")
    private GenderEnum gender;
}
