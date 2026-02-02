# Banking System – Spring Boot

A simple REST-based Banking System built using Spring Boot to understand backend development, REST APIs, and service-layer architecture.

---

## 🚀 Features

- Customer Management (Create, View, Delete)
- Account Management (Create, View, Delete)
- Transaction Operations
  - Deposit
  - Withdraw
  - Check Balance
- REST APIs with proper HTTP status codes
- Logging using SLF4J Logger
- Null-safety using Optional
- Clean Controller–Service architecture

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Web
- Maven
- SLF4J (Logging)
- Postman (API Testing)

---



---

## 🔗 API Endpoints

### Customer APIs
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/api/customers` | Create customer |
| GET | `/api/customers/{id}` | Get customer by ID |
| GET | `/api/customers` | Get all customers |
| DELETE | `/api/customers/{id}` | Delete customer |

---

### Account APIs
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/api/accounts` | Create account |
| GET | `/api/accounts/{id}` | Get account by ID |
| GET | `/api/accounts` | Get all accounts |
| DELETE | `/api/accounts/{id}` | Delete account |

---

### Transaction APIs
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/api/transactions/deposit/{id}` | Deposit money |
| POST | `/api/transactions/withdraw/{id}` | Withdraw money |
| GET | `/api/transactions/balance/{id}` | Check balance |

