package com.moliniao.service.fallback;

import com.moliniao.common.Result;
import com.moliniao.dto.request.OrderInfoReq;
import com.moliniao.dto.response.OrderInfoRes;
import com.moliniao.dto.response.StudentOrderRes;
import com.moliniao.service.StudentOrderServiceFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component // 不要忘记添加，不要忘记添加
public class StudentOrderServiceFeignFallbackFactory implements FallbackFactory<StudentOrderServiceFeign> {

    @Override
    public StudentOrderServiceFeign create(Throwable throwable) {

        return new StudentOrderServiceFeign() {
            @Override
            public Result<StudentOrderRes> getStudentOrderInfo(Long studentId) {
                log.error("{}号学生为查询到相关订单记录,请核对后再试.", studentId);
                StudentOrderRes studentOrderRes = new StudentOrderRes();
                studentOrderRes.setEvaluation("去他妈的鬼，cnmb，老子都快饿死了，还遇到bug。。。。");
                return Result.fail("111", "该学生没有相关订单信息", studentOrderRes);
            }

            @Override
            public Result<OrderInfoRes> addStudentOrderInfo(OrderInfoReq orderInfoReq) {
                log.error("系统繁忙,请稍后再试.");
                return Result.fail("111", "系统繁忙,请稍后再试.");
            }
        };
    }
}
