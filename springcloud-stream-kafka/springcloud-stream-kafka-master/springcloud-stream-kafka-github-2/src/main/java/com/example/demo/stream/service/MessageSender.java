package com.example.demo.stream.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.example.demo.stream.chnnel.MyChnnel;

@Service
@EnableBinding(MyChnnel.class)
public class MessageSender {
	private final Logger logger = LoggerFactory.getLogger(MessageSender.class);

	@Autowired
	private MessageChannel shop_output;//名称必须保证一致


	public void send(String jsonMessage) {
		shop_output.send(MessageBuilder.withPayload(jsonMessage).build());
		System.out.println("发送数据jsonMessage= " + jsonMessage);
	}
}
