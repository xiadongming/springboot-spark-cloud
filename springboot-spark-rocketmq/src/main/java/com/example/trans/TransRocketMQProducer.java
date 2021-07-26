package com.example.trans;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/5/21 18:40
 * @Desc:
 */
@Component
public class TransRocketMQProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send() {
        Message<String> msg = MessageBuilder.withPayload("Hello world!").build();
        rocketMQTemplate.sendMessageInTransaction("myTransactionGroup","spring-tx-my-topic",msg, null);

    }
}

