package com.example.trans;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/5/21 18:48
 * @Desc:
 * 注意：不要使用异步的方式消费消息，如果异步处理，
 *        可能出现：还没处理完成，就返回给broker消费成功，此时实际处理失败，offset提交，则永久丢失了消息
 *
 */
@Component
@RocketMQMessageListener(topic = "spring-tx-my-topic",consumerGroup = "tx-consumer",selectorExpression = "*")
public class TransRocketMQConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("消费者收到： " + s);
    }
}
