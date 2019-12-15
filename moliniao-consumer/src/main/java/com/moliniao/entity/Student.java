package com.moliniao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private Long id;

    private String name;

    private Integer sex;

    private Integer age;

    private String email;

    private String mobile;

    private String address;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updator;

}
