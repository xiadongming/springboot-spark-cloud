package com.example.demo.stream.chnnel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyChnnel {

	 //发消息的通道名称
	String SHOP_OUTPUT = "shop_output";
	
     //消息的订阅通道名称
	String SHOP_INPUT = "shop_input";

	 //发消息的通道
	@Output(SHOP_OUTPUT)
	MessageChannel sendShopMessage();

	 // 收消息的通道
	@Input(SHOP_INPUT)
	SubscribableChannel recieveShopMessage();

}
