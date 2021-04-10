package com.itchina.distribution.service.impl;

import com.alibaba.fastjson.JSON;
import com.itchina.common.constant.Constant;
import com.itchina.distribution.constant.CouponStatus;
import com.itchina.distribution.entity.Coupon;
import com.itchina.distribution.mapper.CouponMapper;
import com.itchina.distribution.service.IKafkaService;
import com.itchina.distribution.vo.CouponKafkaMessage;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * <h1>Kafka 相关的服务接口实现</h1>
 * 核心思想: 是将 Cache 中的 Coupon 的状态变化同步到 DB 中
 */
//@Component
public class KafkaServiceImpl implements IKafkaService {

    @Autowired
    private  CouponMapper couponMapper;


    /**
     * <h2>消费优惠券 Kafka 消息</h2>
     * @param record {@link ConsumerRecord}
     */
    @Override
    @KafkaListener(topics = {Constant.TOPIC}, groupId = "coupon-distribution-group")
    public void consumeCouponKafkaMessage(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            CouponKafkaMessage couponInfo = JSON.parseObject(message.toString(), CouponKafkaMessage.class );

            System.out.println("Receive CouponKafkaMessage: {}"+ message.toString());
            Integer status = couponInfo.getStatus();

            switch (status) {
                case 1:
                    break;
                case 2:
                    processUsedCoupons(couponInfo, status);
                    break;
                case 3:
                    processExpiredCoupons(couponInfo, status);
                    break;
            }
        }
    }

    /**
     * <h2>处理已使用的用户优惠券</h2>
     * */
    private void processUsedCoupons(CouponKafkaMessage kafkaMessage,Integer status) {
        // TODO 给用户发送短信
        processCouponsByStatus(kafkaMessage, status);
    }

    /**
     * <h2>处理过期的用户优惠券</h2>
     * */
    private void processExpiredCoupons(CouponKafkaMessage kafkaMessage, Integer status) {
        // TODO 给用户发送推送
        processCouponsByStatus(kafkaMessage, status);
    }

    /**
     * <h2>根据状态处理优惠券信息</h2>
     * */
    private void processCouponsByStatus(CouponKafkaMessage kafkaMessage,Integer status) {
        List<Coupon> coupons = couponMapper.findAllById(kafkaMessage.getIds()
        );
        if (CollectionUtils.isEmpty(coupons) || coupons.size() != kafkaMessage.getIds().size()) {
            System.out.println("Can Not Find Right Coupon Info: {}"+ JSON.toJSONString(kafkaMessage));
            // TODO 发送邮件
            return;
        }
        coupons.forEach(c -> c.setStatus(String.valueOf(status)));
        System.out.println("CouponKafkaMessage Op Coupon Count: {}"+couponMapper.saveAll(coupons).size());
    }
}
