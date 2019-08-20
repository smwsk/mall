package com.smwsk.mall.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

	String QUEUES_NAME_INPUT = "myMessageInput";
	String QUEUES_NAME_OUTPUT = "myMessageOutput";
	@Input(value = StreamClient.QUEUES_NAME_INPUT)
	SubscribableChannel input();

	@Output(value = StreamClient.QUEUES_NAME_OUTPUT)
	MessageChannel output();


}
