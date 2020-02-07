package br.org.soujava.exemplo_kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TopicBean {
    @Bean
    public NewTopic createTopic() {
        return new NewTopic("teste", 2, (short)1);
    }
}
