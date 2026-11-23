# Task Manager

API REST para gerenciamento de tarefas, desenvolvida em Java com Spring Boot.

> Projeto desenvolvido durante os estudos do **Bootcamp DIO Java com IA**.

## Sobre o projeto

O projeto implementa operações de criação, consulta, atualização e remoção de tarefas. A aplicação segue uma separação simples entre domínio, casos de uso e infraestrutura, facilitando a evolução e os testes do código.

### Funcionalidades

- Criar uma tarefa;
- Listar todas as tarefas;
- Buscar uma tarefa pelo identificador;
- Atualizar uma tarefa;
- Remover uma tarefa;
- Validar os dados de criação;
- Retornar erros de validação e recurso não encontrado;
- Gerar documentação da API com Spring REST Docs.

## Mapa do projeto

```text
src/
├── main/
│   ├── java/io/miguelsouza/taskmanager/
│   │   ├── TaskmanagerApplication.java       # Inicialização da aplicação
│   │   ├── application/                      # Casos de uso e DTOs de aplicação
│   │   │   ├── CreateTaskUseCase.java
│   │   │   ├── GetTasksUseCase.java
│   │   │   ├── GetTaskByIdUseCase.java
│   │   │   ├── UpdateTaskUseCase.java
│   │   │   └── DeleteTaskUseCase.java
│   │   ├── domain/                           # Regras e modelos do domínio
│   │   │   ├── Task.java
│   │   │   ├── TaskId.java
│   │   │   ├── TaskStatus.java
│   │   │   └── TaskRepository.java
│   │   └── infrastructure/                   # Adaptadores externos
│   │       ├── http/                         # Controller, requests e respostas
│   │       └── repository/                   # Repositório em memória
│   └── resources/
│       └── application.properties
├── test/                                     # Testes unitários e de integração
└── docs/asciidoc/index.adoc                  # Documentação gerada da API
```

## Tecnologias

- Java 25;
- Spring Boot 4.0.5;
- Spring Web;
- Spring Validation;
- Gradle;
- Lombok;
- JUnit 5 e Spring Boot Test;
- Spring REST Docs.

## Como executar

### Pré-requisitos

- Java 25 instalado e configurado no `PATH`;
- Windows, Linux ou macOS.

### Executar a aplicação

No Windows:

```bash
.\gradlew.bat bootRun
```

No Linux/macOS:

```bash
./gradlew bootRun
```

A API ficará disponível em `http://localhost:8080`.

### Executar os testes

```bash
.\gradlew.bat test
```

Para gerar a documentação:

```bash
.\gradlew.bat asciidoctor
```

## API

Todas as rotas começam com `/tasks` e utilizam JSON.

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/tasks` | Cria uma tarefa |
| `GET` | `/tasks` | Lista as tarefas |
| `GET` | `/tasks/{id}` | Busca uma tarefa por ID |
| `PATCH` | `/tasks/{id}` | Atualiza uma tarefa |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa |

### Criar tarefa

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Estudar Spring Boot\",\"description\":\"Praticar APIs REST\"}"
```

O campo `title` é obrigatório e deve ter entre 3 e 100 caracteres. O campo `description` é opcional e aceita até 500 caracteres.

Resposta `201 Created`:

```json
{
  "id": "8c2c4c0e-6f43-4dd1-8c28-9c2f66f2e8c1",
  "title": "Estudar Spring Boot",
  "description": "Praticar APIs REST",
  "status": "PENDING"
}
```

### Atualizar tarefa

```json
{
  "title": "Concluir estudos de Spring",
  "description": "Revisar os casos de uso",
  "status": "IN_PROGRESS"
}
```

Os status disponíveis são `PENDING`, `IN_PROGRESS` e `COMPLETED`.

## Persistência

Os dados são armazenados apenas em memória por `InMemoryTaskRepository`. Portanto, todas as tarefas são perdidas quando a aplicação é encerrada ou reiniciada.

## Tratamento de erros

- `400 Bad Request`: dados inválidos na criação da tarefa;
- `404 Not Found`: tarefa não encontrada;
- `204 No Content`: tarefa removida com sucesso.

## Licença

Este projeto foi criado para fins educacionais.
