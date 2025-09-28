

# Warehouse Product Tracker API

This is a backend REST API built with **Spring Boot** and **MySQL** for managing products in a warehouse.
It provides full CRUD operations, stock management, and clean error handling. Good for learning backend development and practicing API design.

---

## Features

* Create, read, update, and delete products
* Increase or decrease stock quantity
* Validation and error handling (e.g., no negative stock)
* Swagger UI for API documentation and testing

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Swagger (API docs)
* Postman (API testing)

---

## API Endpoints

| Method | Endpoint                            | Description          |
| ------ | ----------------------------------- | -------------------- |
| POST   | `/api/products`                     | Create a new product |
| GET    | `/api/products/{id}`                | Get product by ID    |
| GET    | `/api/products`                     | Get all products     |
| PUT    | `/api/products/{id}`                | Update product       |
| DELETE | `/api/products/{id}`                | Delete product       |
| POST   | `/api/products/{id}/stock/increase` | Increase stock       |
| POST   | `/api/products/{id}/stock/decrease` | Decrease stock       |

---

## How to Run Locally

1. Clone the repo

   ```bash
   git clone https://github.com/Shivashankar001/warehouse-product-tracker.git
   ```

2. Create a MySQL database, for example:

   ```sql
   CREATE DATABASE warehouse_db;
   ```

3. Update `application.properties` with your MySQL username and password.

4. Run the app:

   ```bash
   mvn spring-boot:run
   ```

5. Test the API using Postman or Swagger UI.

---

## Swagger UI

When the app is running, open:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Author

**Shiva Shankar**
Java | Spring Boot | MySQL
Based in Hyderabad, India
