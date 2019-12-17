package com.moliniao.service;

import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.service.impl
 */
@FeignClient(value = "moliniao-provider-feign")
public interface StudentOrderServiceFeign {

    @GetMapping(value = "/pfeign/getOrder")
    Result<StudentOrderRes> getStudentOrderInfo(@RequestParam("studentId") Long studentId);

    @PostMapping(value = "/pfeign/addOrder")
    Result<OrderInfoRes> addStudentOrderInfo(OrderInfoReq orderInfoReq);
}