Pedido Service

Microsserviço desenvolvido em Java com Spring Boot para processamento de pedidos baseada em mensageria.

A aplicação utiliza **RabbitMQ** para comunicação entre serviços e **MongoDB** para persistência de dados, garantindo maior escalabilidade e desacoplamento entre os componentes.

Tecnologias Utilizadas

Java

Spring Boot

Spring Data MongoDB

Spring AMQP (RabbitMQ)

MongoDB

RabbitMQ

Docker

🏗 Arquitetura

A aplicação segue uma arquitetura baseada em mensagens, onde a API publica eventos em uma fila e consumidores realizam o processamento.

Fluxo da aplicação:

O cliente envia uma requisição HTTP para criação de um pedido.

A API recebe a requisição e publica uma mensagem na fila do RabbitMQ.

A aplicação consome a mensagem da fila.

O pedido é salvo no MongoDB.

O projeto pode ser executado utilizando Docker Compose para subir as dependências necessárias através do comando: docker-compose up -d

Para testar a parte da API segue um exemplo de endpoint http://localhost:8080/clientes/1/pedidos
