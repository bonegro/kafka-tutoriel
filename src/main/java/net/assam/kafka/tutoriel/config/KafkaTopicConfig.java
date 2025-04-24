package net.assam.kafka.tutoriel.config;

import net.assam.kafka.tutoriel.utils.KafkaUtil;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic newTopic() {
		return TopicBuilder.name(KafkaUtil.FIRST_TOPIC.name())
				.build();
	}

	@Bean
	public NewTopic newJsonTopic() {
		return TopicBuilder.name(KafkaUtil.JSON_MANAGED_TOPIC.name())
				.build();
	}
}
