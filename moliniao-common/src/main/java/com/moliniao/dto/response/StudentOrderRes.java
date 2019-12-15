package com.moliniao.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.res
 */
@Data
public class StudentOrderRes implements Serializable {

    private static final long serialVersionUID = 2571860695324652371L;
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

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    private Date createTime;

}
