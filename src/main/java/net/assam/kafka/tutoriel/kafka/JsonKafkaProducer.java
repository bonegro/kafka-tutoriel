package net.assam.kafka.tutoriel.kafka;

import net.assam.kafka.tutoriel.payload.User;
import net.assam.kafka.tutoriel.utils.KafkaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
	private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private final KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(final KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(final User user) {
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, KafkaUtil.JSON_MANAGED_TOPIC.name())
				.build();
		kafkaTemplate.send(message);
		log.info("Sending user {}", user);
	}
}
