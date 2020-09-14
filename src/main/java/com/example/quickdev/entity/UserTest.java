package com.example.quickdev.entity;

import com.example.quickdev.entity.base.BaseEntity;
import lombok.Data;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiaokun
 */
@Data
public class UserTest extends BaseEntity {

    private String username;
    private String password;
}
