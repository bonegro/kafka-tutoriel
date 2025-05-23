package net.assam.kafka.tutoriel.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "FIRST_TOPIC", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String message) {
		log.info("Consumed message: {}", message);
	}
}
