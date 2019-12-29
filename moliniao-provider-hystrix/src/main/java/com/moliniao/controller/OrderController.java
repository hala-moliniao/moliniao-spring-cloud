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
    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //@HystrixCommand(fallbackMethod = "processFallback")
    public Result<StudentOrderRes> getStudentOrderInfo(@RequestParam Long studentId) {
        StudentOrderRes studentOrderRes = studentOrderService.getStudentOrderInfo(studentId);
        if (null == studentOrderRes) {
            throw new RuntimeException("学号为: " + studentId + "的学生没有订单信息");
        }
        return Result.success(studentOrderRes);
    }

    @PostMapping("/addOrder")
    public Result<OrderInfoRes> addStudentOrderInfo(@RequestBody OrderInfoReq orderInfoReq) {
        OrderInfoRes orderInfoRes = studentOrderService.addStudentOrderInfo(orderInfoReq);
        return Result.success(orderInfoRes);
    }

    public Result<StudentOrderRes> processFallback(@RequestParam Long studentId) {
        StudentOrderRes studentOrderRes = new StudentOrderRes();
        studentOrderRes.setStudentId(studentId);
        studentOrderRes.setEvaluation("学号为: " + studentId + "的学生没有订单信息");
        return Result.fail("111", "调用失败", studentOrderRes);
    }
}
