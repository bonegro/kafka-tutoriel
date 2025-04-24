package net.assam.kafka.tutoriel.kafka;

import net.assam.kafka.tutoriel.utils.KafkaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(String message) {
		log.info("Sending message: {}", message);
		kafkaTemplate.send(KafkaUtil.FIRST_TOPIC.name(), message);
	}
}
