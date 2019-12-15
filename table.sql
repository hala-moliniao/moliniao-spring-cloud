CREATE TABLE `cms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(18) NOT NULL COMMENT '订单号',
  `student_id` bigint(20) NOT NULL COMMENT '学生id',
  `type` int(2) NOT NULL COMMENT '订单类型:1-餐饮;2-娱乐;3-日常',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `trade_type` varchar(50) DEFAULT NULL COMMENT '交易类型:消费;转账;借款',
  `pay_way` varchar(50) DEFAULT NULL COMMENT '支付类型:人脸;微信;支付宝;银行卡',
  `pay_status` varchar(50) DEFAULT NULL COMMENT '支付状态:C-未支付;Y-支付成功;N-支付失败',
  `evaluation` varchar(50) DEFAULT NULL COMMENT '评论',
  `consume_address` varchar(50) DEFAULT NULL COMMENT '消费地址',
  `creator` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updator` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

INSERT INTO `demo`.`cms_order`(`id`, `order_no`, `student_id`, `type`, `total_price`, `trade_type`, `pay_way`, `pay_status`, `evaluation`, `consume_address`, `creator`, `create_time`, `updator`, `update_time`) VALUES (1, 'SDNO20191214161912', 2, 1, 129.60, '消费', '支付宝', 'Y', '这家店的米饭特别香', '长泰广场', '朱丽叶', '2019-12-12 16:59:04', NULL, NULL);
INSERT INTO `demo`.`cms_order`(`id`, `order_no`, `student_id`, `type`, `total_price`, `trade_type`, `pay_way`, `pay_status`, `evaluation`, `consume_address`, `creator`, `create_time`, `updator`, `update_time`) VALUES (2, 'SDNO20191215164643', 5, 2, 399.99, '转账', '银行卡', 'N', '招商银行转账没有手续费', '申城佳苑', 'system', '2019-12-15 16:46:43', NULL, NULL);
INSERT INTO `demo`.`cms_order`(`id`, `order_no`, `student_id`, `type`, `total_price`, `trade_type`, `pay_way`, `pay_status`, `evaluation`, `consume_address`, `creator`, `create_time`, `updator`, `update_time`) VALUES (3, 'SDNO20191215164833', 3, 2, 699.99, '转账', '微信', 'C', '微信付款', '孙桥镇', 'system', '2019-12-15 16:48:33', NULL, NULL);
INSERT INTO `demo`.`cms_order`(`id`, `order_no`, `student_id`, `type`, `total_price`, `trade_type`, `pay_way`, `pay_status`, `evaluation`, `consume_address`, `creator`, `create_time`, `updator`, `update_time`) VALUES (4, 'SDNO20191215165949', 1, 2, 399.99, '转账', '银行卡', 'N', '招商银行转账没有手续费', '申城佳苑', 'system', '2019-12-15 16:59:49', NULL, NULL);
INSERT INTO `demo`.`cms_order`(`id`, `order_no`, `student_id`, `type`, `total_price`, `trade_type`, `pay_way`, `pay_status`, `evaluation`, `consume_address`, `creator`, `create_time`, `updator`, `update_time`) VALUES (5, 'SDNO20191215170507', 4, 2, 399.99, '转账', '银行卡', 'N', '招商银行转账没有手续费', '申城佳苑', 'system', '2019-12-15 17:05:07', NULL, NULL);


CREATE TABLE `cms_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别:0-男;1-女',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '邮箱',
  `mobile` varchar(11) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '联系方式',
  `address` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '家庭住址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='学生表';


INSERT INTO `demo`.`cms_student`(`id`, `name`, `sex`, `age`, `email`, `mobile`, `address`, `create_time`, `creator`, `update_time`, `updator`) VALUES (1, '李明洲', 0, 29, 'limingzhou@cloudwalk.cn', 'yckj2786', '商汤科技', '2019-11-05 18:12:12', 1, NULL, NULL);
INSERT INTO `demo`.`cms_student`(`id`, `name`, `sex`, `age`, `email`, `mobile`, `address`, `create_time`, `creator`, `update_time`, `updator`) VALUES (2, '朱丽叶', 1, 5, 'zhuliye@163.com', 'yckj2767', '依图科技', '2019-05-05 12:32:24', 2, NULL, NULL);
INSERT INTO `demo`.`cms_student`(`id`, `name`, `sex`, `age`, `email`, `mobile`, `address`, `create_time`, `creator`, `update_time`, `updator`) VALUES (3, '罗密欧', 0, 23, 'luomiou@126.com', 'yckj2753', '云从科技', '2019-11-06 14:39:46', 2, NULL, NULL);
INSERT INTO `demo`.`cms_student`(`id`, `name`, `sex`, `age`, `email`, `mobile`, `address`, `create_time`, `creator`, `update_time`, `updator`) VALUES (4, '煤老板', 1, 32, 'meilaoban@google.com', 'yckj2754', '旷视科技', '2019-11-20 11:39:49', 2, NULL, NULL);
INSERT INTO `demo`.`cms_student`(`id`, `name`, `sex`, `age`, `email`, `mobile`, `address`, `create_time`, `creator`, `update_time`, `updator`) VALUES (5, '高含', 0, 28, 'gaohan@126.com', 'yckj2394', '微软科技', '2019-12-15 17:13:14', 2, NULL, NULL);

