package com.moliniao.service;

import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.service.impl
 */
public interface StudentOrderService {

    StudentOrderRes getStudentOrderInfo(Long studentId);

    OrderInfoRes addStudentOrderInfo(OrderInfoReq orderInfoReq);
}
