
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