package com.example.demo.kafka1.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class MyMessageListener  {

	@KafkaListener(topics = {"test-topic-xmd-2108004"},groupId = "test-consumer-group")
	public void onMessage(ConsumerRecord<String, String> consumerRecords) {
		System.out.println("收到的消息是==============");
		System.out.println(consumerRecords.value());
	}

}
