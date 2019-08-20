package com.smwsk.mall.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收端
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

	@StreamListener(value = StreamClient.QUEUES_NAME_INPUT)
	public void processInput(Object message){
		log.info("StreamReceiver processInput: {}", message);
	}

	@StreamListener(value = StreamClient.QUEUES_NAME_OUTPUT)
	public void processOutput(Object message){
		log.info("StreamReceiver processOutput: {}", message);
	}

}
