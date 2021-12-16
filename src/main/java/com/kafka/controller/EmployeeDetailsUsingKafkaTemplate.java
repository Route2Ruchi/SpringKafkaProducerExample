package com.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeDetailsUsingKafkaTemplate {

	private final Logger log = LoggerFactory.getLogger(EmployeeDetailsUsingKafkaTemplate.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "employeeDetailsTopic";
	
	@RequestMapping(method = RequestMethod.POST, path = "/saveDetails")
	public void saveEmployeeDetailsusingKafkaTemplate(@RequestBody Employee emp) throws Exception {
		log.info("Sending message to kafka topic using kafka template");
		ObjectMapper mapper = new ObjectMapper();
		log.info("JSON Payload to be published:: {}", mapper.writeValueAsString(emp));
		kafkaTemplate.send(kafkaTopic,mapper.writeValueAsString(emp));
		log.info("Message Sent");
	}
}
