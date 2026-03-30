# ATM Banking System

A simple ATM backend application built with Java and Spring Boot as a university learning project. Implements basic banking operations through a REST API.

## Features

- **Account Management** — Create new bank accounts
- **Deposit** — Add funds to an existing account
- **Withdrawal** — Withdraw funds with balance validation
- **Balance Inquiry** — Check current account balance

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot | Backend framework |
| Spring Data JPA | Database operations |
| PostgreSQL | Database |
| Maven | Build tool |

## Project Structure

```
src/main/java/com/inexx/atm_project/
├── controller/       # REST API endpoints
├── dto/              # Data Transfer Objects
├── entity/           # JPA entities
├── exception/        # Global error handling
├── repository/       # Database layer
└── servieces/impl/   # Business logic
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/accounts` | Create a new account |
| GET | `/api/accounts/{id}` | Get account details |
| PUT | `/api/accounts/{id}/deposit` | Deposit money |
| PUT | `/api/accounts/{id}/withdraw` | Withdraw money |

## How to Run

1. Make sure you have Java 17+ and PostgreSQL installed
2. Create a database and update `src/main/resources/application.properties`
3. Run the project:

```bash
./mvnw spring-boot:run
```

## What I Learned

This was my first backend project using Spring Boot. Through this project I practiced:
- Setting up a REST API with Spring Boot
- Using JPA and Hibernate for database operations
- Implementing a layered architecture (Controller → Service → Repository)
- Basic error handling with `@ControllerAdvice`

---

Built by [INEXX](https://github.com/INEXX-max) — İnönü University, Computer Science
