package net.assam.kafka.tutoriel.controller;

import net.assam.kafka.tutoriel.kafka.JsonKafkaProducer;
import net.assam.kafka.tutoriel.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	private final JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(final JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}

	@PostMapping("/publish")
	public ResponseEntity<User> publish(@RequestBody final User user) {
		jsonKafkaProducer.send(user);
		return ResponseEntity.ok(user);
	}
}
