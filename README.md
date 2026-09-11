# Task Manager Backend

Spring Boot + Maven REST API.

## Requirements

- Java 17+
- Maven 3.9+

## Run

```bash
mvn spring-boot:run
```

API:
- `GET http://localhost:8080/api/tasks`
- `POST http://localhost:8080/api/tasks`
- `GET http://localhost:8080/api/tasks/health`

For the first learning stage, H2 is used so the project can run without installing MySQL. Later, Kubernetes will use MySQL as the database service.
