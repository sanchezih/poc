package com.netsurfingzone.consumer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.dto.Student;

@RestController
@RequestMapping("/consume")
public class Consumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;

	@GetMapping("/message")
	public Student consumeMessage() {

		Student student = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
			student = mapper.readValue(jsonMessage, Student.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}