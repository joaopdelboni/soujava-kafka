
# Kafka na modernização de sistemas bancários

O conteúdo desse repositório é parte da apresentação realizada para comunidade SouJava (<https://www.meetup.com/pt-BR/SouJava/events/268154472/>)

## Requisitos para execução do código

- Docker
- JDK 8+
- Maven
- Editor de sua Preferência

## Subindo seu próprio Cluster

Para iniciar seu cluster vamos utilizar uma imagem docker contendo um setup de desenvolvimento do kafka, este setup atende todos os requisitos para execução (Zookeeper, Kafka e uma Interface Gráfica).

Utilize o seguinte comando para iniciar o uma instância:

`docker run --rm -e ADV_HOST=localhost -p 3030:3030 -p 9092:9092 -e RUNNING_SAMPLEDATA=0 -e RUNTESTS=0 -e CONNECT_PORT=0 lensesio/fast-data-dev`

Mais detalhes da imagem em: <https://github.com/lensesio/fast-data-dev>

### Mapa de Parametros

- `-e ADV_HOST=localhost` Define qual o host pelo qual o kafka responderá
- `-p 3030:3030 -p 9092:9092` Expõe as portas 3030 (Inteface Web) e 9092 (Porta de comunicação do Kafka)
- `-e RUNNING_SAMPLEDATA=0` Desabilita a geração de dados de exemplo
- `-e RUNTESTS=0` Desabilita a execução dos testes após a inicialização do container
- `-e CONNECT_PORT=0` Desabilita a instância de Kafka Connect presente na imagem

## Execução da Aplicação

Dentro do diretório da aplicação execute:

`mvn spring-boot:run`

## Configurações utilizadas nos exemplos

Para os exemplos apresentados utilizamos as seguintes congfigurações:

```
 spring.kafka.bootstrap-servers=localhost:9092 #Endpoint de Conexão do Kafka
 spring.kafka.consumer.group-id=teste #Consumer group padrão para os listeners
 
 spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer #Classe de serialização do produtor
 spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer #Classe de Serialização do consumidor
 spring.kafka.consumer.properties.spring.json.trusted.packages=br.org.soujava.exemplokafka.model #Pacote que contém classes seguras para deserialização
```

## Configurações mapeadas para o Spring Kafka

| Propriedade                                    | Valor Padrão                                 | Descrição                                                                                                                                                                    |
|------------------------------------------------|----------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| spring.kafka.admin.client-id                   |                                              | ID to pass to the server when making requests. Used for server-side logging.                                                                                                 |
| spring.kafka.admin.fail-fast                   | false                                        | Whether to fail fast if the broker is not available on startup.                                                                                                              |
| spring.kafka.admin.properties.*                |                                              | Additional admin-specific properties used to configure the client.                                                                                                           |
| spring.kafka.admin.ssl.key-password            |                                              | Password of the private key in the key store file.                                                                                                                           |
| spring.kafka.admin.ssl.key-store-location      |                                              | Location of the key store file.                                                                                                                                              |
| spring.kafka.admin.ssl.key-store-password      |                                              | Store password for the key store file.                                                                                                                                       |
| spring.kafka.admin.ssl.key-store-type          |                                              | Type of the key store.                                                                                                                                                       |
| spring.kafka.admin.ssl.protocol                |                                              | SSL protocol to use.                                                                                                                                                         |
| spring.kafka.admin.ssl.trust-store-location    |                                              | Location of the trust store file.                                                                                                                                            |
| spring.kafka.admin.ssl.trust-store-password    |                                              | Store password for the trust store file.                                                                                                                                     |
| spring.kafka.admin.ssl.trust-store-type        |                                              | Type of the trust store.                                                                                                                                                     |
| spring.kafka.bootstrap-servers                 |                                              | Comma-delimited list of host:port pairs to use for establishing the initial connections to the Kafka cluster. Applies to all components unless overridden.                   |
| spring.kafka.client-id                         |                                              | ID to pass to the server when making requests. Used for server-side logging.                                                                                                 |
| spring.kafka.consumer.auto-commit-interval     |                                              | Frequency with which the consumer offsets are auto-committed to Kafka if 'enable.auto.commit' is set to true.                                                                |
| spring.kafka.consumer.auto-offset-reset        |                                              | What to do when there is no initial offset in Kafka or if the current offset no longer exists on the server.                                                                 |
| spring.kafka.consumer.bootstrap-servers        |                                              | Comma-delimited list of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for consumers.                  |
| spring.kafka.consumer.client-id                |                                              | ID to pass to the server when making requests. Used for server-side logging.                                                                                                 |
| spring.kafka.consumer.enable-auto-commit       |                                              | Whether the consumer's offset is periodically committed in the background.                                                                                                   |
| spring.kafka.consumer.fetch-max-wait           |                                              | Maximum amount of time the server blocks before answering the fetch request if there isn't sufficient data to immediately satisfy the requirement given by "fetch-min-size". |
| spring.kafka.consumer.fetch-min-size           |                                              | Minimum amount of data the server should return for a fetch request.                                                                                                         |
| spring.kafka.consumer.group-id                 |                                              | Unique string that identifies the consumer group to which this consumer belongs.                                                                                             |
| spring.kafka.consumer.heartbeat-interval       |                                              | Expected time between heartbeats to the consumer coordinator.                                                                                                                |
| spring.kafka.consumer.isolation-level          |                                              | Isolation level for reading messages that have been written transactionally.                                                                                                 |
| spring.kafka.consumer.key-deserializer         |                                              | Deserializer class for keys.                                                                                                                                                 |
| spring.kafka.consumer.max-poll-records         |                                              | Maximum number of records returned in a single call to poll().                                                                                                               |
| spring.kafka.consumer.properties.*             |                                              | Additional consumer-specific properties used to configure the client.                                                                                                        |
| spring.kafka.consumer.ssl.key-password         |                                              | Password of the private key in the key store file.                                                                                                                           |
| spring.kafka.consumer.ssl.key-store-location   |                                              | Location of the key store file.                                                                                                                                              |
| spring.kafka.consumer.ssl.key-store-password   |                                              | Store password for the key store file.                                                                                                                                       |
| spring.kafka.consumer.ssl.key-store-type       |                                              | Type of the key store.                                                                                                                                                       |
| spring.kafka.consumer.ssl.protocol             |                                              | SSL protocol to use.                                                                                                                                                         |
| spring.kafka.consumer.ssl.trust-store-location |                                              | Location of the trust store file.                                                                                                                                            |
| spring.kafka.consumer.ssl.trust-store-password |                                              | Store password for the trust store file.                                                                                                                                     |
| spring.kafka.consumer.ssl.trust-store-type     |                                              | Type of the trust store.                                                                                                                                                     |
| spring.kafka.consumer.value-deserializer       |                                              | Deserializer class for values.                                                                                                                                               |
| spring.kafka.jaas.control-flag                 | required                                     | Control flag for login configuration.                                                                                                                                        |
| spring.kafka.jaas.enabled                      | false                                        | Whether to enable JAAS configuration.                                                                                                                                        |
| spring.kafka.jaas.login-module                 | com.sun.security.auth.module.Krb5LoginModule | Login module.                                                                                                                                                                |
| spring.kafka.jaas.options.*                    |                                              | Additional JAAS options.                                                                                                                                                     |
| spring.kafka.listener.ack-count                |                                              | Number of records between offset commits when ackMode is "COUNT" or "COUNT_TIME".                                                                                            |
| spring.kafka.listener.ack-mode                 |                                              | Listener AckMode. See the spring-kafka documentation.                                                                                                                        |
| spring.kafka.listener.ack-time                 |                                              | Time between offset commits when ackMode is "TIME" or "COUNT_TIME".                                                                                                          |
| spring.kafka.listener.client-id                |                                              | Prefix for the listener's consumer client.id property.                                                                                                                       |
| spring.kafka.listener.concurrency              |                                              | Number of threads to run in the listener containers.                                                                                                                         |
| spring.kafka.listener.idle-event-interval      |                                              | Time between publishing idle consumer events (no data received).                                                                                                             |
| spring.kafka.listener.log-container-config     |                                              | Whether to log the container configuration during initialization (INFO level).                                                                                               |
| spring.kafka.listener.missing-topics-fatal     | true                                         | Whether the container should fail to start if at least one of the configured topics are not present on the broker.                                                           |
| spring.kafka.listener.monitor-interval         |                                              | Time between checks for non-responsive consumers. If a duration suffix is not specified, seconds will be used.                                                               |
| spring.kafka.listener.no-poll-threshold        |                                              | Multiplier applied to "pollTimeout" to determine if a consumer is non-responsive.                                                                                            |
| spring.kafka.listener.poll-timeout             |                                              | Timeout to use when polling the consumer.                                                                                                                                    |
| spring.kafka.listener.type                     | single                                       | Listener type.                                                                                                                                                               |
| spring.kafka.producer.acks                     |                                              | Number of acknowledgments the producer requires the leader to have received before considering a request complete.                                                           |
| spring.kafka.producer.batch-size               |                                              | Default batch size. A small batch size will make batching less common and may reduce throughput (a batch size of zero disables batching entirely).                           |
| spring.kafka.producer.bootstrap-servers        |                                              | Comma-delimited list of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for producers.                  |
| spring.kafka.producer.buffer-memory            |                                              | Total memory size the producer can use to buffer records waiting to be sent to the server.                                                                                   |
| spring.kafka.producer.client-id                |                                              | ID to pass to the server when making requests. Used for server-side logging.                                                                                                 |
| spring.kafka.producer.compression-type         |                                              | Compression type for all data generated by the producer.                                                                                                                     |
| spring.kafka.producer.key-serializer           |                                              | Serializer class for keys.                                                                                                                                                   |
| spring.kafka.producer.properties.*             |                                              | Additional producer-specific properties used to configure the client.                                                                                                        |
| spring.kafka.producer.retries                  |                                              | When greater than zero, enables retrying of failed sends.                                                                                                                    |
| spring.kafka.producer.ssl.key-password         |                                              | Password of the private key in the key store file.                                                                                                                           |
| spring.kafka.producer.ssl.key-store-location   |                                              | Location of the key store file.                                                                                                                                              |
| spring.kafka.producer.ssl.key-store-password   |                                              | Store password for the key store file.                                                                                                                                       |
| spring.kafka.producer.ssl.key-store-type       |                                              | Type of the key store.                                                                                                                                                       |
| spring.kafka.producer.ssl.protocol             |                                              | SSL protocol to use.                                                                                                                                                         |
| spring.kafka.producer.ssl.trust-store-location |                                              | Location of the trust store file.                                                                                                                                            |
| spring.kafka.producer.ssl.trust-store-password |                                              | Store password for the trust store file.                                                                                                                                     |
| spring.kafka.producer.ssl.trust-store-type     |                                              | Type of the trust store.                                                                                                                                                     |
| spring.kafka.producer.transaction-id-prefix    |                                              | When non empty, enables transaction support for producer.                                                                                                                    |
| spring.kafka.producer.value-serializer         |                                              | Serializer class for values.                                                                                                                                                 |
| spring.kafka.properties.*                      |                                              | Additional properties, common to producers and consumers, used to configure the client.                                                                                      |
| spring.kafka.ssl.key-password                  |                                              | Password of the private key in the key store file.                                                                                                                           |
| spring.kafka.ssl.key-store-location            |                                              | Location of the key store file.                                                                                                                                              |
| spring.kafka.ssl.key-store-password            |                                              | Store password for the key store file.                                                                                                                                       |
| spring.kafka.ssl.key-store-type                |                                              | Type of the key store.                                                                                                                                                       |
| spring.kafka.ssl.protocol                      |                                              | SSL protocol to use.                                                                                                                                                         |
| spring.kafka.ssl.trust-store-location          |                                              | Location of the trust store file.                                                                                                                                            |
| spring.kafka.ssl.trust-store-password          |                                              | Store password for the trust store file.                                                                                                                                     |
| spring.kafka.ssl.trust-store-type              |                                              | Type of the trust store.                                                                                                                                                     |
| spring.kafka.streams.application-id            |                                              | Kafka streams application.id property; default spring.application.name.                                                                                                      |
| spring.kafka.streams.auto-startup              | true                                         | Whether or not to auto-start the streams factory bean.                                                                                                                       |
| spring.kafka.streams.bootstrap-servers         |                                              | Comma-delimited list of host:port pairs to use for establishing the initial connections to the Kafka cluster. Overrides the global property, for streams.                    |
| spring.kafka.streams.cache-max-size-buffering  |                                              | Maximum memory size to be used for buffering across all threads.                                                                                                             |
| spring.kafka.streams.client-id                 |                                              | ID to pass to the server when making requests. Used for server-side logging.                                                                                                 |
| spring.kafka.streams.properties.*              |                                              | Additional Kafka properties used to configure the streams.                                                                                                                   |
| spring.kafka.streams.replication-factor        |                                              | The replication factor for change log topics and repartition topics created by the stream processing application.                                                            |
| spring.kafka.streams.ssl.key-password          |                                              | Password of the private key in the key store file.                                                                                                                           |
| spring.kafka.streams.ssl.key-store-location    |                                              | Location of the key store file.                                                                                                                                              |
| spring.kafka.streams.ssl.key-store-password    |                                              | Store password for the key store file.                                                                                                                                       |
| spring.kafka.streams.ssl.key-store-type        |                                              | Type of the key store.                                                                                                                                                       |
| spring.kafka.streams.ssl.protocol              |                                              | SSL protocol to use.                                                                                                                                                         |
| spring.kafka.streams.ssl.trust-store-location  |                                              | Location of the trust store file.                                                                                                                                            |
| spring.kafka.streams.ssl.trust-store-password  |                                              | Store password for the trust store file.                                                                                                                                     |
| spring.kafka.streams.ssl.trust-store-type      |                                              | Type of the trust store.                                                                                                                                                     |
| spring.kafka.streams.state-dir                 |                                              | Directory location for the state store.                                                                                                                                      |
| spring.kafka.template.default-topic            |                                              | Default topic to which messages are sent.                                                                                                                                    |

Fonte: <https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html>