package com.kafka.configbasic.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;



@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Autowired
	private ConsumerFactory<Integer, String> consumerFactory;

	
	public Map<String, Object> consumerConfig(){
		Map<String, Object> kafkaAutoConfig = ((DefaultKafkaConsumerFactory<Integer, String>) consumerFactory).getConfigurationProperties();
		Map<String, Object> consumerConfig = new HashMap<>();
		consumerConfig.putAll(kafkaAutoConfig);
		return consumerConfig;
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfig()));
		return factory;
	}
}
