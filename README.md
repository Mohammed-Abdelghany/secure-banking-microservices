# Secure Banking Microservices

A cloud-native microservices project built using Java, Spring Boot, and Spring Cloud.

This repository contains multiple independent microservices communicating through REST APIs and service discovery mechanisms while following modern microservices architecture practices.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Cloud
- Spring Security
- Spring Data JPA
- Docker (Learning in progress)
- Kubernetes (Learning in progress)
- Helm (Learning in progress)
- API Gateway
- Config Server
- Eureka Discovery Server
- Resilience4j
- RabbitMQ / Kafka
- H2 Database

---

## 🏗️ Architecture

The project follows a distributed microservices architecture.

### Core Components

- Config Server
- Eureka Discovery Server
- API Gateway
- Authentication & Authorization
- Independent Business Services

---

## 📦 Microservices Included

| Service | Description |
|---|---|
| accounts-service | Manages customer accounts using H2 Database |
| cards-service | Handles card operations |
| loans-service | Manages loan processing |
| gateway-server | API Gateway for routing |
| config-server | Centralized configuration |
| discovery-server | Service registry using Eureka |

---

## ⚙️ Features

- RESTful APIs
- Centralized Configuration
- Service Discovery
- API Gateway Routing
- Circuit Breaker Pattern
- JWT Authentication
- Secure Communication
- Scalable Architecture

---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/Mohammed-Abdelghany/secure-banking-microservices.git
```

### Run Services

```bash
mvn spring-boot:run
```

---

## 📚 Learning Goals

This project was built while learning and practicing:

- Microservices Architecture
- Cloud Native Development
- Spring Cloud Ecosystem
- Security in Distributed Systems
- Containerization & Orchestration (Currently Learning)
- CI/CD Concepts

---

## 📌 Future Improvements

- Add Docker Support
- Add Kubernetes Deployment
- Add Helm Charts
- Add CI/CD Pipelines
- Add Observability Stack
- Add Distributed Tracing
- Add Unit & Integration Testing

---

## 👨‍💻 Author

Muhammed Abd El-Ghany 
Junior Backend Developer | Java & Spring Boot Enthusiast
