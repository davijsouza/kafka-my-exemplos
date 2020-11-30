package com.kafka.configbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.configbasic.factory.KafkaProducerServiceImpl;


@SpringBootApplication
public class KafkaConfigApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConfigApplication.class, args);
	}

	@Autowired
	private KafkaProducerServiceImpl load;
	
	
	@Override
	public void run(String... strings) throws Exception {
        String data = "Spring Kafka Producer and Consumer Example";
        load.send(data);
    }

}
