package com.example.quickdev.dto.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 10:12
 */
@Data
public class BaseDTO implements Serializable {

    /**
     * 主键ID
     */
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    /**
     * 创建人ID
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long createBy;

    /**
     * 创建日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 最后修改人ID
     */
    @JsonSerialize(using=ToStringSerializer.class)
    private Long modifyBy;

    /**
     * 最后修改日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    /**
     * 数据状态
     */
    private Byte status;
}
