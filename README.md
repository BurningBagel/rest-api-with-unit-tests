# rest-api-with-unit-tests
Projeto de gerenciamento de cervejas em API RESTful via Spring Boot

# Requisitos
-Java 11 ou melhor

-Maven 3.7.6 ou melhor

# Descrição
Este projeto é um exemplo de implementação de uma API com testes unitários compreensivos. Esta oferece acesso a um banco de dados de 1 tabela(Beer), com uma camada intermediária de acesso(DTO), já que acesso direto ao banco de dados seria perigoso. 

Para executar este projeto, deve-se utilizar o seguinte comando no terminal:

```shell script
mvn spring-boot:run
```
Uma vez ativado, a API pode ser acessada via o endereço:

```
http://localhost:8080/api/v1/people
```
