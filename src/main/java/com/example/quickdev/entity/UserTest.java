package com.example.quickdev.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxiaokun
 */
@Data
public class UserTest {

    private Long id;
    private String username;
    private String password;
    private Date created;
    private Long createdBy;
}
