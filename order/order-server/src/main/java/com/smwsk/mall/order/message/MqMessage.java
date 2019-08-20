package com.smwsk.mall.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收mq消息
 */
@Slf4j
@Component
public class MqMessage {

//	1.@RabbitListener(queues = "myQueues")
//	2.自动创建队列 @RabbitListener(queuesToDeclare = {@Queue(value = "myQueues")})
//	3.自动创建Exchange和Queue绑定
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "myQueue"),
			exchange = @Exchange(value = "myExchange")
	))
	public void process(String message){
		log.info("MqMessage receive:{}",message);
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "computerOrder"),
			exchange = @Exchange(value = "myOrder"),
			key = "computer"
	))
	public void processComputer(String message){
		log.info("computer receive:{}",message);
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "fruitOrder"),
			exchange = @Exchange(value = "myOrder"),
			key = "fruit"
	))
	public void fruitComputer(String message){
		log.info("fruit receive:{}",message);
	}

}