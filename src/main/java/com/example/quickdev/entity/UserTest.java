package com.example.quickdev.entity;

import lombok.Data;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiaokun
 */
@Data
public class UserTest implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Date created;
    private Long createdBy;
    private Date date;
}
