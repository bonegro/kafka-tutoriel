package net.assam.kafka.tutoriel.kafka;

import net.assam.kafka.tutoriel.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	@KafkaListener(topics = "JSON_MANAGED_TOPIC", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(User user) {
		log.info("Json Consumed Message: {}", user.toString());
	}
}
