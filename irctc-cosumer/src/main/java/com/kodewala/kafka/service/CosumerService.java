package com.kodewala.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CosumerService {
	
	@KafkaListener(topics = "booking-confirmed", groupId = "CG1")
	public void cosume(ConsumerRecord<String, String> record)
	{
		System.out.println("kafkaCosumerRecord......");
		
		String message = record.value();
		
		System.out.println("kafkaCosumer......" + message);
	}

}
