package br.org.soujava.exemplo_kafka;

import br.org.soujava.exemplo_kafka.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableKafka
public class ExemploKafkaApplication implements CommandLineRunner {
	@Autowired
	private KafkaTemplate<String, Cliente> template;

	public static void main(String[] args) {
		SpringApplication.run(ExemploKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			template.send("teste", "1" + i, new Cliente("Cliente "+i, "teste"+i+"@gmail.com"));
		}
	}
}
