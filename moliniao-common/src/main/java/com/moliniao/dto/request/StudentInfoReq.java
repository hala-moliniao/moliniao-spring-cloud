package com.moliniao.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.req
 */
@Data
public class StudentInfoReq implements Serializable {

    private static final long serialVersionUID = 6679835148877775276L;
    private Long studentId;
}
