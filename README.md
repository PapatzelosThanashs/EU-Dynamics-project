# Project: Simple Web application

A full-stack web application with a **Spring Boot** backend and **Vue.js** frontend for user management.

---

## 🚀 Features

- RESTful API for user CRUD operations
- Validation with groups for create and patch operations
- Clean separation of backend and frontend code
- Vue.js SPA consuming backend APIs
- API documentation with Swagger UI (springdoc-openapi)
- Database migrations with Flyway
- DTO mapping using MapStruct
- Lombok to reduce boilerplate code
- Unit and integration tests for backend and frontend

---

## 🛠️ Technologies Used

| Layer    | Technology                        |
| -------- | -------------------------------- |
| Backend  | Java 17, Spring Boot 3.4.5, Maven |
| ORM      | Spring Data JPA, Hibernate        |
| Database | MySQL                         |
| Validation | Jakarta Bean Validation          |
| Mapping  | MapStruct 1.5.5                  |
| Boilerplate Reduction | Lombok 1.18.30             |
| Migrations | Flyway Core                    |
| API Docs | springdoc-openapi/Swagger 2.8.6           |
| Frontend | Vue.js 3, Vue Router, Axios |
| Testing  | JUnit 5, Mockito, Vue Test Utils  |
> *Note: Testing is planned but not fully implemented yet.*
---

## 📁 Project Structure

```
/EU-Dynamics-project
├── demo/            # Spring Boot backend source code
├── frontend/        # Vue.js frontend source code
└── README.md        # This file
```

---

## ⚙️ Prerequisites

- **Java 17+**
- **Maven 3.9.9**
- **Node.js v22.15.0**
- **npm** 

---

## 🔧 Setup & Run( seperately each framework at development )

### Backend Setup

```bash
cd demo
mvn clean install
mvn spring-boot:run
```

- Backend runs on: [http://localhost:8081](http://localhost:8081)

### Frontend Setup

Open a new terminal:

```bash
cd frontend
npm install
npm run serve
```

- Frontend runs on: [http://localhost:8080](http://localhost:8080) 

### Access Application

Open [http://localhost:8080](http://localhost:8080) in your browser.

---

## 🛠️ Build for Production (Bundled .jar)

### Frontend Setup

Open a new terminal:

```bash
cd frontend
npm install
npm run build
```
- This generates a dist/ directory containing production-ready static files (HTML, CSS, JS).

### Backend Setup
- Change branch "prod" 


```bash
git branch prod
cp -r frontend/dist/* backend/src/main/resources/static/
cd demo
mvn clean package
```
- The executable file generated at target/demo-1.0.0.jar. You can run it now by:
```bash
java -jar target/demo-1.0.0.jar
```

### Access Application

Open [http://localhost:8080](http://localhost:8080) in your browser.



## ⚙️ Configuration

### Backend - for development

Edit `demo/src/main/resources/application.properties`.

Example application.properties config:

```properties
# Database connection
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=username
spring.datasource.password=password

# JPA configuration
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

#Flyway settings
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
logging.level.org.flywaydb=DEBUG

#Actuator (leave * to show all )
management.endpoints.web.exposure.include=health, info, metrics
management.endpoints.web.base-path=/manage

#OpenAPI/Swagger (http://localhost:8080/swagger-ui.html)
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html


# Set root logging level
logging.level.root=INFO

# Set specific package logging level
logging.level.com.project.demo=DEBUG

# Output to a file (optional)
logging.file.name=logs/app.log
logging.file.path=logs/


spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```


## 📄 API Documentation

Swagger UI is enabled in the backend.

Access it at:

```
http://localhost:8080/swagger-ui.html
```

You can view all available endpoints, request/response models, and try API calls interactively.





