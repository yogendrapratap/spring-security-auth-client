# Spring Security Auth Client

A Spring Boot application demonstrating authentication and authorization using JWT, custom security filters, and exception handling. The project is configured to work with MySQL and integrates with an OAuth2 resource server.

## Features

- JWT-based authentication and authorization
- Custom role conversion from JWT claims
- CSRF protection with cookie-based tokens
- Custom access denied and authentication entry point handlers
- CORS configuration for frontend integration
- RESTful endpoints with role-based access control

## Tech Stack

- Java
- Spring Boot
- Spring Security
- OAuth2 Resource Server
- Maven
- MySQL

## Endpoints

| Endpoint      | Method | Access         | Description                |
|---------------|--------|----------------|----------------------------|
| `/users`      | GET    | USER role      | Get user details           |
| `/myAccount`  | GET    | ADMIN role     | Get account details        |
| `/dealer`     | GET    | DEALER role    | Get dealer details         |
| `/contact`    | GET    | Authenticated  | Contact info               |
| `/info`       | GET    | Public         | General info               |

## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL

### Configuration

Edit `src/main/resources/application.properties` to set your database and security settings.

### Build & Run

```bash
mvn clean install
mvn spring-boot:run
