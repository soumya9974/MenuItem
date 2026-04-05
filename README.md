# MenuItem Management System
## Overview
The **MenuItem Management System** is a backend application designed to manage menu items efficiently. It provides functionality to create, update, delete, and retrieve menu items with attributes such as name, price, category, and availability.

This service can be integrated into larger systems such as:

* Restaurant Management Systems
* Food Ordering Applications
* Microservices-based Menu/Inventory Services

---

## Features

* Add new menu items
* Update existing menu items
* Delete menu items
* View all menu items
* Search or filter menu items *(optional enhancement)*

---

## Tech Stack

### Backend

* Java with Spring Boot *(or .NET equivalent)*
* RESTful APIs

### Tools

* Maven / Gradle
* Postman (API testing)

### Database

* MySQL (recommended for development)
* H2 (in-memory database for testing)

---

## Database Configuration

To connect the application to a database, update the following file:

```
src/main/resources/application.properties
```

### MySQL Configuration

```
spring.datasource.url=jdbc:mysql://localhost:3306/menuitemdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## Database Setup Steps

1. Install MySQL (or any preferred database)
2. Create a database:

```
CREATE DATABASE menuitemdb;
```

3. Update credentials in `application.properties`
4. Run the application — tables will be created automatically

---

## H2 Database (Optional for Testing)

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Access H2 Console

```
http://localhost:8080/h2-console
```

---

## API Endpoints

| Method | Endpoint         | Description             |
| ------ | ---------------- | ----------------------- |
| GET    | /menu-items      | Retrieve all menu items |
| GET    | /menu-items/{id} | Retrieve item by ID     |
| POST   | /menu-items      | Create new menu item    |
| PUT    | /menu-items/{id} | Update menu item        |
| DELETE | /menu-items/{id} | Delete menu item        |

---

## Project Structure

```
MenuItem/
│
├── src/
│   ├── main/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── model/
│   │   └── repository/
│   │
│   └── test/
│
├── pom.xml / build.gradle
└── README.md
```

---

## How to Run

### 1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/menu-item.git
cd menu-item
```

### 2. Build the project

```
mvn clean install
```

### 3. Run the application

```
mvn spring-boot:run
```

### 4. Access the API

```
http://localhost:8083
```

---

## Testing

* Use Postman or similar tools to test APIs
* Add unit tests for controllers and services

---

## Notes

* Ensure the database server is running before starting the application
* Update port if your database runs on a different port (default: 3306)
* Do not commit sensitive credentials to version control

---

## Future Enhancements

* Implement JWT-based authentication
* Integrate with a frontend (React / Angular)
* Add pagination and sorting
* Introduce role-based access control

---

## Author

Soumya Kappera
