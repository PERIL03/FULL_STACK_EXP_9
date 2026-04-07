# DEMOJWT - Spring Boot JWT Authentication Demo

This project is a beginner-friendly Spring Boot backend that demonstrates a simple JWT-based login flow using Spring Security, Spring Data JPA, and MySQL.

## Overview

The application provides:
- A login endpoint that validates username/password from the database
- JWT token generation on successful login
- Sample public endpoints to verify the app is running

Current scope is intentionally simple for learning and experimentation.

## Tech Stack

- Java 21
- Spring Boot 3.2.5
- Spring Web
- Spring Security
- Spring Data JPA
- MySQL (runtime)
- H2 (runtime dependency included)
- JJWT 0.11.5
- Maven Wrapper

## Project Structure

```
src/main/java/com/AML3B/DEMO_JWT/
  config/
    SecurityConfig.java
  controller/
    AuthController.java
    HomeController.java
  model/
    User.java
  repository/
    UserRepository.java
  security/
    JwtUtil.java
  service/
    AuthService.java
```

## API Endpoints

### 1) Health/Home endpoint
- Method: GET
- URL: `/`
- Response:

```text
DEMOJWT is running. Use /api/hello or /api/login
```

### 2) Login endpoint
- Method: POST
- URL: `/api/login`
- Input: request parameters
  - `username`
  - `password`
- Success response: JWT token string
- Failure response: `Invalid Credentials`

Example using curl:

```bash
curl -X POST "http://localhost:8080/api/login?username=admin&password=admin123"
```

### 3) Sample endpoint
- Method: GET
- URL: `/api/hello`
- Response:

```text
Hello! JWT Authentication Successful
```

## Prerequisites

- Java 21 installed
- MySQL running locally
- Maven (optional, wrapper is included)

## Database Configuration

Current configuration is in `src/main/resources/application.properties`:

- URL: `jdbc:mysql://localhost:3306/JwtDemo`
- Username: `root`
- Password: configured in file

Before running, ensure:
1. Database `JwtDemo` exists.
2. `users` table has at least one record.
3. Username/password values match what you use in login requests.

Suggested table structure:

```sql
CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);
```

Sample user:

```sql
INSERT INTO users (username, password) VALUES ('admin', 'admin123');
```

## Run the Project

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or with installed Maven:

```bash
mvn spring-boot:run
```

App starts at:
- `http://localhost:8080`

## Build and Test

Build:

```bash
./mvnw clean package
```

Run tests:

```bash
./mvnw test
```

## Important Notes (Current Implementation)

This project is a learning demo and has a few intentional simplifications:

- All endpoints are currently permitted in `SecurityConfig` (`anyRequest().permitAll()`).
- Password comparison in `AuthService` is plain text (`equals`) instead of password hashing.
- JWT validation filter is not yet wired into the request pipeline.
- JWT secret is hardcoded in `JwtUtil`.

For production-ready security, improve these areas first.

## Recommended Next Improvements

1. Hash and verify passwords with `BCryptPasswordEncoder`.
2. Move secrets and DB credentials to environment variables.
3. Add JWT authentication filter and protect private endpoints.
4. Return structured JSON responses instead of plain strings.
5. Add integration tests for login and token validation.

## Author

Created for JWT authentication learning and full-stack practice.