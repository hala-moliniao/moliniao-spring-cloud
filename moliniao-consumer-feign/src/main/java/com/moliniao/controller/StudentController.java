package com.moliniao.controller;

import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.moliniao.consumer.endpoint
 */
@RestController
public class StudentController {

    private static final String REST_URL_PREFIX = "http://localhost:8081";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentService studentService;

    @GetMapping("/queryOrderRest")
    public Result<StudentOrderRes> getOrderInfoRest(@RequestParam Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/provider/getOrder?studentId=" + id, Result.class);
    }

    @PostMapping("/addOrderRest")
    public Result<OrderInfoRes> addOrderInfoRest(@RequestBody OrderInfoReq orderInfoReq) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/provider/addOrder", orderInfoReq, Result.class);
    }

    @GetMapping("/queryOrder")
    public Result<StudentOrderRes> getOrderInfo(@RequestParam Long id) {
        StudentOrderRes studentOrder = studentService.getStudentOrder(id);
        return Result.success(studentOrder);
    }

    @PostMapping("/addOrder")
    public Result<OrderInfoRes> addOrderInfo(@RequestBody OrderInfoReq orderInfoReq) {
        OrderInfoRes orderInfoResResult = studentService.addOrderInfo(orderInfoReq);
        return Result.success(orderInfoResResult);
    }

    @GetMapping(value = "/studentDiscovery")
    public Object studentDiscovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/provider/orderDiscovery", Object.class);
    }
}
