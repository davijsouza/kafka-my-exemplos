package com.kafka.configbasic.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${app.topic.producer}")
    private String Topic;
	
	@Override
	public void send(String data) {
		kafkaTemplate.send(Topic, data);
	}
	
	
}
