# 🚀 Smart Loan Application — Microservices Architecture

## 🧠 Overview

**Smart Loan Application** is a scalable, secure, microservices-based system for managing user and employee operations related to loan origination and processing. It uses:

- 🧩 Microservices (User, Employee, Loan)
- 📨 RabbitMQ (Event-driven messaging)
- 🐘 PostgreSQL (Relational database)
- 🔐 JWT Authentication

---

## 🏗️ Architecture

### 📦 Microservices

- **User Service**
  - Handles Sign Up / Sign In
  - Submits loan applications
  - Publishes loan events to queue

- **Employee Service**
  - Consumes from loan queue
  - Reviews applications (approve/reject)
  - Updates loan status and logs events

- **Loan Service**
  - Centralizes loan info, tracks status
  - Coordinates applications from user and decisions from employee

- **RabbitMQ Message Broker**
  - Decouples communication between microservices
  - Ensures reliable event delivery

---

## 🔐 JWT Security

- Uses **JWT tokens** for user and employee auth
- Token issued after login
- Sent in header for all protected endpoints

