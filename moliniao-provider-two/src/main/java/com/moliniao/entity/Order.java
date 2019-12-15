package com.moliniao.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -393571086246632242L;
    private Long id;

    private String orderNo;

    private Long studentId;

    private Integer type;

    private BigDecimal totalPrice;

    private String tradeType;

    private String payWay;

    private String payStatus;

    private String evaluation;

    private String consumeAddress;

    private String creator;

    private Date createTime;

    private String updator;

    private Date updateTime;
}
