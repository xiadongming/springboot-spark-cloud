package com.example.common;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/5/21 18:07
 * @Desc:
 */
@Component
public class RocketMQProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send() {
        String msg = "Hello world! ";
        //发送消息
        //rocketMQTemplate.convertAndSend("Topic1:TagA", msg);

        //发送spring的Message
        //rocketMQTemplate.send("Topic1:TagA", MessageBuilder.withPayload(msg).build());

        //发送异步消息
        /*rocketMQTemplate.asyncSend("Topic1:TagA", msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }
            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });*/
        //发送顺序消息
        rocketMQTemplate.syncSendOrderly("Topic1", "98456237,完成", "98456237");
        rocketMQTemplate.syncSendOrderly("Topic1", "98456237,创建", "98456237");
        rocketMQTemplate.syncSendOrderly("Topic1", "98456237,支付", "98456237");

    }
}
