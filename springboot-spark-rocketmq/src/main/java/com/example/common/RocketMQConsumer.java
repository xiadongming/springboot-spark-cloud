package com.example.common;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/5/21 18:17
 * @Desc:
 */
@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "base_group_syncMsg")
public class RocketMQConsumer implements RocketMQListener<String> {
    private static final Logger logger = LoggerFactory.getLogger(RocketMQConsumer.class);
    @Override
    public void onMessage(String s) {
       logger.info("消费者收到的消息msg= {}",s);
    }
}
