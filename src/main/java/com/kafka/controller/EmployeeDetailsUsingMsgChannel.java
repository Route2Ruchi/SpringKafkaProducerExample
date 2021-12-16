package com.kafka.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.config.CirrusKafkaChannel;
import com.kafka.model.Employee;

@RestController
@RequestMapping("/kafkaMsg")
@EnableBinding({ CirrusKafkaChannel.class })
public class EmployeeDetailsUsingMsgChannel {

private final Logger log = LoggerFactory.getLogger(EmployeeDetailsUsingKafkaTemplate.class);
	
    @Autowired
    private CirrusKafkaChannel kafkaChannel;
    
    MessageChannel messageChannel;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, path = "/saveEmpDetails")
	public void saveEmployeeDetailsUsingMsgChannel(@RequestBody Employee emp) throws Exception {
		Map<String, String> headers = null;
		log.info("Sending message to kafka topic using Message Channel");
		messageChannel = kafkaChannel.topicName();
		messageChannel.send(new GenericMessage(emp.toString(),headers));
		log.info("Message Sent to the kafka topic");
	}
	
}
