package com.moliniao.enumeration;

import lombok.Getter;

/**
 * @author: created by limingzhou
 * @date: 2019/12/13
 * @description: com.com.moliniao.moliniao.common.enumeration
 */
@Getter
public enum PayStatusEnum {

    NOT_PAID("C","未支付"),
    PAID_SUCCESS("C","未支付"),
    PAID_FAIL("C","未支付");

    private String code;

    private String message;

    PayStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
