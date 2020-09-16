package com.example.quickdev.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.quickdev.entity.base.BaseEntity;
import com.example.quickdev.enums.GenderEnum;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiaokun
 */
@Data
@TableName("T_USER_TEST")
public class UserTest extends BaseEntity {

    private String username;
    private String password;
    private GenderEnum gender;
}
