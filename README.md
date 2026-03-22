# Nexus-RPG
Projeto Extensionista Integrador - Engenharia de Software 5º Semestre Matutino - UNIVAG

---

## Integrantes

* Dhiogo Nascimento
* Flávio Gimenes
* Guilherme [Sobrenome]
* Matheus [Sobrenome]

---

## Tecnologias Utilizadas

### Backend (API)

* **Java 21+** com **Spring Boot**
* **Segurança:** Spring Security
* **Persistência:** JPA / Hibernate
* **Banco de Dados:** PostgreSQL ou MariaDB
* **Documentação:** OpenAPI (Swagger)
* **Monitoramento:** Spring Boot Actuator
* **Utilitários:** Lombok, Bean Validation, MapStruct

### Frontend (App)

* **Framework:** React Native com Expo
* **Comunicação:** Axios
* **Documentação:** TypeDoc

---

## Como Executar

### Pré-requisitos

* Java JDK 17 ou superior.
* Node.js (LTS).
* PostgreSQL ou MariaDB instalado.

### Backend

1. Navegue até a pasta `/api`.
2. Configure as credenciais do banco no arquivo `application.properties` ou `application.yml`.
3. Execute o comando: `./mvnw spring-boot:run`

### Frontend

1. Navegue até a pasta `/app`.
2. Instale as dependências: `npm install`
3. Inicie o projeto: `npx expo start`

---

## Documentação Adicional

* **API:** Após rodar o backend, acesse `http://localhost:8080/swagger-ui.html` para visualizar os endpoints.
