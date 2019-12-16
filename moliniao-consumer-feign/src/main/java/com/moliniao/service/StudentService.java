package com.moliniao.service;

import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.moliniao.consumer.service.impl
 */

public interface StudentService {

    StudentOrderRes getStudentOrder(Long id);

    OrderInfoRes addOrderInfo(OrderInfoReq orderInfoReq);

}
