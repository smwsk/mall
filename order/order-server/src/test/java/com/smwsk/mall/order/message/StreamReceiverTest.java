package com.smwsk.mall.order.message;

import com.smwsk.mall.order.OrderServerApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

import static org.junit.Assert.*;

public class StreamReceiverTest extends OrderServerApplicationTests {

	@Autowired
	StreamClient streamClient;

	@Test
	public void process() {
		String message = new Date().toString();
		streamClient.output().send(MessageBuilder.withPayload(message).build());

	}

	@Test
	public void processInput() {
		String message = new Date().toString();
		streamClient.input().send(MessageBuilder.withPayload(message).build());
	}

	@Test
	public void processOutput() {
		String message = new Date().toString();
		streamClient.output().send(MessageBuilder.withPayload(message).build());
	}
}