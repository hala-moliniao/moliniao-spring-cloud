package com.moliniao.service.impl;


import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentOrderServiceFeign;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentOrderServiceFeign studentOrderServiceFeign;

    @Override
    public StudentOrderRes getStudentOrder(Long id) {
        Result<StudentOrderRes> result = studentOrderServiceFeign.getStudentOrderInfo(id);
        return result.getData();
    }

    @Override
    public OrderInfoRes addOrderInfo(OrderInfoReq orderInfoReq) {
        Result<OrderInfoRes> result = studentOrderServiceFeign.addStudentOrderInfo(orderInfoReq);
        return result.getData();
    }
}
