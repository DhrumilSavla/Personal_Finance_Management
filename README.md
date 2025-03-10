Personal Finance Management API
This project provides RESTful APIs for managing budgets, expenses, income, transactions, and users in a Personal Finance Management System. It follows a microservices architecture and includes API Gateway for centralized routing and Eureka Server for service discovery.

📦 Technologies Used
Spring Boot - Backend Framework
Spring Cloud Gateway - API Gateway
Eureka Server - Service Discovery
MySQL - Database
RestTemplate- Inter-service communication
Docker - Containerization

🌐 Microservices Architecture
API Gateway (/api/**) - Centralized entry point for all services
Eureka Server (/eureka) - Service discovery for microservices
Budget Service (/budget) - Manages budget-related operations
Expense Service (/expense) - Handles expense tracking
Income Service (/income) - Manages user income records
Transaction Service (/transactions) - Records and retrieves transactions
User Service (/user) - Manages user details

📌 API Endpoints

1️⃣ API Gateway (/api/**)
All requests are routed through the API Gateway.
Example:
bash
Copy
Edit
http://localhost:8080/api/budget

2️⃣ Budget Service (/budget)
POST /budget → Create a new budget
GET /budget/{id} → Retrieve budget by ID
GET /budget → Get all budgets
PUT /budget/{id} → Update budget by ID
DELETE /budget/{id} → Delete budget by ID

3️⃣ Expense Service (/expense)
POST /expense → Create a new expense
GET /expense/{id} → Retrieve expense by ID
GET /expense → Get all expenses
PUT /expense/{id} → Update expense by ID
DELETE /expense/{id} → Delete expense by ID

4️⃣ Income Service (/income)
POST /income → Create a new income record
GET /income/{accountNumber} → Get income details by account number
PUT /income/update-balance/{accountNumber} → Update user balance based on income
GET /income/total-income/{accountNumber} → Fetch dynamically updated user balance

5️⃣ Transaction Service (/transactions)
POST /transactions → Create a new transaction
GET /transactions/{id} → Retrieve transaction by ID
GET /transactions → Get all transactions
GET /transactions/total-income/{accountNumber} → Get total income for an account

6️⃣ User Service (/user)
POST /user → Create a new user
GET /user/{id} → Retrieve user by ID
GET /user → Get all users
PUT /user/{id} → Update user details
DELETE /user/{id} → Delete user by ID

🚀 Running the Application
1️⃣ Start Eureka Server
Eureka enables service registration and discovery.
Navigate to the Eureka Server project directory.
mvn spring-boot:run
Access Eureka Dashboard:
http://localhost:8761

2️⃣ Start API Gateway
Navigate to the API Gateway project directory.
mvn spring-boot:run
Test by calling:
http://localhost:9090/api/user

3️⃣ Start Each Microservice
Each microservice should be started separately.

4️⃣ Testing API Gateway
Instead of calling microservices directly, use:

GET http://localhost:9090/api/budget/{id}       # Calls Budget Service
POST http://localhost:9090/api/expense          # Calls Expense Service
GET http://localhost:9090/api/income/{account}  # Calls Income Service
GET http://localhost:9090/api/transactions      # Calls Transaction Service
POST http://localhost:9090/api/user             # Calls User Service
