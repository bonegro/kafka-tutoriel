package net.assam.kafka.tutoriel.controller;

import net.assam.kafka.tutoriel.kafka.KafkaProducer;
import net.assam.kafka.tutoriel.utils.KafkaUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	private final KafkaProducer kafkaProducer;

	public MessageController(final KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		kafkaProducer.send(message);
		return ResponseEntity.ok(String.format("Message sent to the topic : %s", KafkaUtil.FIRST_TOPIC.name()));
	}
}
