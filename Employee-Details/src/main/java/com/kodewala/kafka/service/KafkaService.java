package com.kodewala.kafka.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	@Autowired
	KafkaTemplate<String, String> template;
	
	public void publishMessage(String _topic, String _message)
	{
		System.out.println("...........Start_kafka..............");
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("employee-biodata", null, _message);
		template.send(record);
		
		System.out.println("...........End_kafka..............");
	}

}
