# Nexus-RPG
Projeto Extensionista Integrador - Engenharia de Software 5º Semestre Matutino - UNIVAG

---

## Integrantes

* Dhiogo [Sobrenome]
* Flávio [Sobrenome]
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

## Estrutura do Projeto

O projeto é organizado seguindo princípios de **Clean Architecture**, visando a separação de responsabilidades e fácil manutenção:

```text
/
├── app/              # Código fonte do Frontend (React Native)
├── api/              # Código fonte do Backend (Spring Boot)
│   ├── controller/   # Endpoints e DTOs (Request/Response)
│   ├── model/        # Entidades
│   ├── service/      # Regras de negócio e orquestração
│   ├── repository/   # Acesso ao banco de dados
│   ├── mapper/       # Conversão entre Entidades e DTOs
│   ├── exception/    # Tratamento global de erros
│   └── validator/    # Validações personalizadas
└── resources/        # Recursos de suporte
    ├── db/           # Scripts SQL (schema, inserts)
    ├── assets/       # Diagramas e documentação visual
    └── api/          # Coleção de requisições para testes

```

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

## 📖 Documentação Adicional

* **API:** Após rodar o backend, acesse `http://localhost:8080/swagger-ui.html` para visualizar os endpoints.
* **Banco de Dados:** Consulte o arquivo `docs/db/db.me` para instruções detalhadas sobre o esquema e migrações.

---
