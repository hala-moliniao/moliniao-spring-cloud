package com.moliniao.controller;

import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.endpoint
 */
@RestController
public class OrderController {

    @Autowired
    private StudentOrderService studentOrderService;

    @GetMapping("/getOrder")
    public Result<StudentOrderRes> getStudentOrderInfo(@RequestParam Long studentId) {
        StudentOrderRes studentOrderRes = studentOrderService.getStudentOrderInfo(studentId);
        return Result.success(studentOrderRes);
    }

    @PostMapping("/addOrder")
    public Result<OrderInfoRes> addStudentOrderInfo(@RequestBody OrderInfoReq orderInfoReq) {
        OrderInfoRes orderInfoRes = studentOrderService.addStudentOrderInfo(orderInfoReq);
        return Result.success(orderInfoRes);
    }
}
