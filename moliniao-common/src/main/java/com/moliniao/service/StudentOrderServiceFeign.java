package com.moliniao.service;

import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.fallback.StudentOrderServiceFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.service.impl
 */
@FeignClient(value = "moliniao-provider-feign",fallbackFactory = StudentOrderServiceFeignFallbackFactory.class)
public interface StudentOrderServiceFeign {

    @GetMapping(value = "/profeign/getOrder")
    Result<StudentOrderRes> getStudentOrderInfo(@RequestParam("studentId") Long studentId);

    @PostMapping(value = "/profeign/addOrder")
    Result<OrderInfoRes> addStudentOrderInfo(OrderInfoReq orderInfoReq);
}
