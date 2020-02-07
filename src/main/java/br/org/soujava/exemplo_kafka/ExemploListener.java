package br.org.soujava.exemplo_kafka;

import br.org.soujava.exemplo_kafka.model.Cliente;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExemploListener {
    private static final Logger log = LoggerFactory.getLogger(ExemploListener.class);

    @KafkaListener(topics = "teste", concurrency = "3")
    public void recebiMensagem(ConsumerRecord<String, Cliente> record) {
        log.info("Mensagem recebida: {}, partição: {}, offset: {}, thread: {}", record.value(), record.partition(), record.offset(), Thread.currentThread().getId());
    }

    @KafkaListener(topics = "teste", groupId = "teste2")
    public void recebiMensagem2(ConsumerRecord<String, Cliente> record) {
        log.info("Mensagem recebida2: {}, partição: {}, offset: {}", record.value(), record.partition(), record.offset());
    }
}
