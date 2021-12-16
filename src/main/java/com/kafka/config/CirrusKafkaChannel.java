package com.kafka.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public interface CirrusKafkaChannel {

		@Output("employeeDetailsUsingMsgChannelTopic")
		MessageChannel topicName();
	}
