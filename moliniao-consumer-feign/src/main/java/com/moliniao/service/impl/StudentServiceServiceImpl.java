package com.moliniao.service.impl;


import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentOrderService;
import com.moliniao.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.moliniao.consumer.service.impl
 */
@Slf4j
@Service
public class StudentServiceServiceImpl implements StudentService {

    @Autowired
    private StudentOrderService studentOrderService;

    @Override
    public StudentOrderRes getStudentOrder(Long id) {
        StudentOrderRes studentOrderInfo = studentOrderService.getStudentOrderInfo(id);
        return studentOrderInfo;
    }

    @Override
    public OrderInfoRes addOrderInfo(OrderInfoReq orderInfoReq) {
        OrderInfoRes orderInfoRes = studentOrderService.addStudentOrderInfo(orderInfoReq);
        return orderInfoRes;
    }
}
