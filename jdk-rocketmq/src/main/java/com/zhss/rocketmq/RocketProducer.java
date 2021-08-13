package com.zhss.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Date: 2021/8/13 0:54
 * @Desc:
 */
public class RocketProducer {

    public static final String NAMESRV_ADDR = "127.0.0.1:9876";

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");
        producer.setNamesrvAddr(NAMESRV_ADDR);
        producer.start();
        for (int i = 0; i <10; i++) {
            Message message = new Message("test_quick_topic",//主题
                    "tagA", //标签
                    "key" + i, //自定义key，唯一标识
                    ("Hello RocketMQ=" + i).getBytes()); //消息内容实体 (byte[])
            SendResult result = producer.send(message);
            System.out.println("第" + i + "条消息发出，结果：" + result);
        }
        producer.shutdown();

    }

}
