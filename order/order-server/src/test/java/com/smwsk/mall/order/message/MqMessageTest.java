package com.smwsk.mall.order.message;

import com.smwsk.mall.order.OrderServerApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class MqMessageTest extends OrderServerApplicationTests {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void process() {
		amqpTemplate.convertAndSend("myQueues","now" + new Date());
	}


	@Test
	public void computerProcess() {
		amqpTemplate.convertAndSend("myOrder","computer","now" + new Date());
	}

	@Test
	public void fruitProcess() {
		amqpTemplate.convertAndSend("myOrder","fruit","now" + new Date());
	}
}