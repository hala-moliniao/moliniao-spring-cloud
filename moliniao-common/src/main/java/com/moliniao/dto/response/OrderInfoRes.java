package com.moliniao.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: created by limingzhou
 * @date: 2019/12/14
 * @description: com.moliniao.dto.response
 */
@Data
public class OrderInfoRes implements Serializable {
    private static final long serialVersionUID = 9082765567558756564L;

    private String orderNo;
}
