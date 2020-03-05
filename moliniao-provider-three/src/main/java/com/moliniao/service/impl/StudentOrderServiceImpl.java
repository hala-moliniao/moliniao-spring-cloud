package com.moliniao.service.impl;

import com.moliniao.common.SystemConstant;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.entity.Order;
import com.moliniao.mapper.OrderMapper;
import com.moliniao.service.StudentOrderService;
import com.moliniao.util.OrderIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: com.com.moliniao.moliniao.consumer.service.impl
 */
@Slf4j
@Service
public class StudentOrderServiceImpl implements StudentOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public StudentOrderRes getStudentOrderInfo(Long studentId) {
        List<Order> orderInfos = orderMapper.getOrderInfo(studentId);
        StudentOrderRes studentOrderRes = new StudentOrderRes();
        BeanUtils.copyProperties(orderInfos.get(0),studentOrderRes);
        return studentOrderRes;
    }

    @Override
    public OrderInfoRes addStudentOrderInfo(OrderInfoReq orderInfoReq) {
        Order orderInfo = new Order();
        BeanUtils.copyProperties(orderInfoReq,orderInfo);
        String orderId = OrderIdUtil.getOrderId();
        orderInfo.setOrderNo(orderId);
        orderInfo.setCreateTime(new Date());
        orderInfo.setCreator(SystemConstant.CREATOR);
        orderMapper.insertStudentOrderInfo(orderInfo);
        OrderInfoRes orderInfoRes = new OrderInfoRes();
        orderInfoRes.setOrderNo(orderId);
        return orderInfoRes;
    }
}
