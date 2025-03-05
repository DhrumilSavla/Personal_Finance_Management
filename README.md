# Personal Finance Management API

This project provides RESTful APIs for managing **budgets, expenses, income, transactions, and users** in a **Personal Finance Management System**.

## **📌 API Endpoints**

### **1️⃣ Budget Service (`/budget`)**
- **`POST /budget`** → Create a new budget
- **`GET /budget/{id}`** → Retrieve budget by ID
- **`GET /budget`** → Get all budgets
- **`PUT /budget/{id}`** → Update budget by ID
- **`DELETE /budget/{id}`** → Delete budget by ID

### **2️⃣ Expense Service (`/expense`)**
- **`POST /expense`** → Create a new expense
- **`GET /expense/{id}`** → Retrieve expense by ID
- **`GET /expense`** → Get all expenses
- **`PUT /expense/{id}`** → Update expense by ID
- **`DELETE /expense/{id}`** → Delete expense by ID

### **3️⃣ Income Service (`/income`)**
- **`POST /income`** → Create a new income record
- **`GET /income/{accountNumber}`** → Get income details by account number
- **`PUT /income/update-balance/{accountNumber}`** → Update user balance based on income
- **`GET /income/total-income/{accountNumber}`** → Fetch dynamically updated user balance

### **4️⃣ Transaction Service (`/transactions`)**
- **`POST /transactions`** → Create a new transaction
- **`GET /transactions/{id}`** → Retrieve transaction by ID
- **`GET /transactions`** → Get all transactions
- **`GET /transactions/total-income/{accountNumber}`** → Get total income for an account

### **5️⃣ User Service (`/user`)**
- **`POST /user`** → Create a new user
- **`GET /user/{id}`** → Retrieve user by ID
- **`GET /user`** → Get all users
- **`PUT /user/{id}`** → Update user details
- **`DELETE /user/{id}`** → Delete user by ID

## **📦 Technologies Used**
- **Spring Boot** - Backend Framework
- **MySQL** - Database
- **RestTemplate** - Inter-service communication
- **Docker** - Containerization

## **🚀 Running the Application**
1. **Start MySQL Database**
2. **Run Each Service Separately:**
   ```sh
   mvn spring-boot:run
   ```
3. **Access APIs via Postman**

