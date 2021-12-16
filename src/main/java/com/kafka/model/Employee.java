package com.kafka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Data;

@Data
@JsonPOJOBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	private int id;
	private String name;
	
}
