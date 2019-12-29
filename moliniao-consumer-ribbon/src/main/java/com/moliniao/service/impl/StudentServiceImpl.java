package com.moliniao.service.impl;


import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.moliniao.consumer.service.impl
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Result<StudentOrderRes> getStudentOrder(Long id) {
        return null;
    }

    @Override
    public Result<OrderInfoRes> addOrderInfo(OrderInfoReq orderInfoReq) {
        return null;
    }
}
