# Sistema de Gerenciamento de Agendamentos para Autônomos

![Status do Projeto](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

Um web service back-end (API REST) desenvolvido com Spring Boot para a gestão completa de agendamentos, serviços e finanças de profissionais autônomos.

## Sobre o Projeto

Este projeto visa fornecer uma solução robusta para que profissionais autônomos (como terapeutas, consultores, instrutores, etc.) onde possam gerenciar suas operações diárias.

O profissional pode administrar sua **Disponibilidade** (ex: "segundas, das 8h às 18h"), e o sistema gera automaticamente **Horários de Atendimento** (slots) que podem ser agendados pelos clientes.

O sistema também foi modelado para prover:
* Histórico de agendamentos (passados e futuros).
* Histórico de atendimentos (serviços concluídos).
* Visualização de recebimentos mensais.
* Gerenciamento de catálogo de serviços e seus respectivos valores.

### Status Atual
Atualmente, o projeto foca **exclusivamente no back-end** e na modelagem das lógicas de negócio utilizando o ecossistema Spring. O front-end será desenvolvido posteriormente e consumirá esta API.

---

## Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias e dependências:

* **Java:** Versão `21`
* **Spring Boot:** Versão `3.5.6`
* **Spring Web:** Para criação de endpoints RESTful (`spring-boot-starter-web`).
* **Spring Data JPA:** Para persistência de dados e abstração de consultas (`spring-boot-starter-data-jpa`).
* **H2 Database:** Banco de dados em memória para desenvolvimento e testes (`h2database`).
* **Spring Boot Validation:** Para validação dos dados de entrada (DTOs) (`spring-boot-starter-validation`).
* **Lombok:** Para reduzir código boilerplate (getters, setters, construtores).
* **Spring Boot DevTools:** Para live-reload em ambiente de desenvolvimento.
* **Maven:** Gerenciador de dependências e build.

*(Nota: A camada de segurança com Spring Security está planejada, mas ainda não foi implementada neste estágio do projeto.)*

---

## Como Executar o Projeto

Siga os passos abaixo para clonar e executar a aplicação em seu ambiente local.

### Pré-requisitos
* **JDK 21** (ou superior)
* **Apache Maven** (3.6 ou superior)
* Um cliente de API (como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/)) para testar os endpoints.

### Passos para Instalação

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/caiopaiiva/gestor_agendamento.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd NOME-DO-REPOSITORIO
    ```

3.  **Compile e instale as dependências (Maven):**
    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação Spring Boot:**
    ```bash
    mvn spring-boot:run
    ```

### Acesso à Aplicação

* **API:** A aplicação estará disponível em `http://localhost:8080`
* **Console H2 (Banco de Dados):** Você pode acessar o console do banco H2 em `http://localhost:8080/h2-console`
    * **JDBC URL:** `jdbc:h2:mem:testdb` (ou verifique seu `application.properties`)
    * **User Name:** `root`
    * **Password:** 123

---

## Mapeamento de Endpoints da API

Abaixo está um mapa preliminar dos endpoints RESTful planejados para a aplicação.

*(Esta seção deve ser atualizada conforme o desenvolvimento avança.)*

### 💼 Serviços (CRUD)

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/servicos` | Cria um novo serviço (para o profissional). |
| `GET` | `/api/servicos` | Lista todos os serviços do profissional. |
| `GET` | `/api/servicos/{id}` | Busca um serviço específico por ID. |
| `PUT` | `/api/servicos/{id}` | Atualiza um serviço existente. |
| `DELETE` | `/api/servicos/{id}` | Remove um serviço. |

### 📅 Disponibilidade (Profissional)

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/disponibilidade` | Cadastra um novo bloco de disponibilidade (ex: Segundas, 8h-12h). |
| `GET` | `/api/disponibilidade` | Lista todas as disponibilidades do profissional. |
| `DELETE` | `/api/disponibilidade/{id}` | Remove um bloco de disponibilidade. |

### ⏰ Horários de Atendimento (Slots)

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/horarios/gerar` | (Ação) Gera os slots de atendimento com base na disponibilidade. |
| `GET` | `/api/horarios/disponiveis` | Lista todos os horários (slots) livres para agendamento. |
| `GET` | `/api/horarios/todos` | Lista todos os horários (livres e ocupados). |

### 🗓️ Agendamentos

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/agendamentos` | (Cliente) Realiza um novo agendamento em um horário livre. |
| `GET` | `/api/agendamentos/profissional` | (Profissional) Vê seu histórico de agendamentos. |
| `GET` | `/api/agendamentos/cliente/{clienteId}` | (Cliente) Vê seu histórico de agendamentos. |
| `PUT` | `/api/agendamentos/{id}/cancelar` | Cancela um agendamento (requer lógica de permissão). |
| `PUT` | `/api/agendamentos/{id}/concluir` | (Profissional) Marca um atendimento como concluído. |

### 📊 Financeiro e Histórico

| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/atendimentos` | Lista atendimentos concluídos (para histórico). |
| `GET` | `/api/recebimentos/mensal` | Retorna um resumo de recebimentos (mês atual/passado). |

---

## Próximos Passos

* [ ] Implementar a camada de autenticação e autorização com **Spring Security** e JWT.
* [ ] Substituir o H2 por um banco de dados persistente (ex: PostgreSQL ou MySQL) para o perfil de produção.
* [ ] Escrever testes unitários e de integração.
* [ ] Iniciar o desenvolvimento da aplicação **front-end** (React, Vue, Angular, etc.).
* [ ] Implementar o deploy (ex: Heroku, AWS, Azure).
