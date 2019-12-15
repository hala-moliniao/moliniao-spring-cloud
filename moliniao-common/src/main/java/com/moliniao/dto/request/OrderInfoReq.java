package com.moliniao.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: created by limingzhou
 * @date: 2019/12/14
 * @description: com.moliniao.dto.request
 */
@Data
public class OrderInfoReq implements Serializable {

    private static final long serialVersionUID = -7142290488630584101L;

    private Long studentId;

    private Integer type;

    private BigDecimal totalPrice;

    private String tradeType;

    private String payWay;

    private String payStatus;

    private String evaluation;

    private String consumeAddress;
}
