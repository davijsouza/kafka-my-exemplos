package com.kafka.configbasic.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService{

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);
	
	@KafkaListener(topics = {"#{'${app.topic.consumer}'.split(',')}"}, groupId="app")
	public void receive(@Payload String data) {
		logger.info("data: {}", data);
	}
	
}