package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private AmqpAdmin amqpAdmin;
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private RabbitTemplate rabbitTemplate;


	@Test
	public void contextLoads() {
		//amqpTemplate.convertAndSend("hello.direct","direct.routing.A","Hello!Rabbit!!");
//		Object msg = amqpTemplate.receiveAndConvert("queueA");
//		System.out.println(msg.toString());

	}

}
