# 𝚂𝚙𝚛𝚒𝚗𝚐 𝙱𝚘𝚘𝚝 𝙲𝚁𝚄𝙳 𝙴𝚡𝚊𝚖𝚙𝚕𝚎 🌐

## **Overview**
Welcome to my simple Spring Boot CRUD application! 🌟 This project allows you to perform basic CRUD operations on a "Product" entity, showcasing Spring Boot's capabilities.

## **Getting Started**

### **Prerequisites**
1. **Download the Project:**
   - Download the project by clicking the "Download ZIP" button or clone it using Git.

2. **Open in IntelliJ:**
   - Unzip the downloaded file.
   - Open IntelliJ IDEA and choose "Open" to load the project as an existing project.

3. **Database Setup:**
   - Create a database schema named "Product" (or configure your preferred database).
   - Update your DBMS connection configuration in the `application.properties` file.

   ```properties
   # DataSource Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_here?useSSL=false
   spring.datasource.username=your_username_here
   spring.datasource.password=your_password_here
  
Replace your_username_here and your_password_here with your actual database username and password. Uncomment and configure any additional properties based on your specific requirements.

4. **Run the Application:**
Run the application on http://localhost:8080.
Ensure that the port is available.

## **Features**
- **🚀 Technology Stack:**
  - Spring Boot for building the service.
  - Spring Data JPA for data access.
  - MySQL as the database.

- **🌈 Entity Model:**
  - Simple "Product" entity with attributes (id, name, price, quantity).

- **🛠 CRUD Operations:**
  - Create, Read, Update, and Delete operations for the "Product" entity.
  - RESTful endpoints: POST, GET, PUT, DELETE.

- **🔍 Validation:**
  - Request data validation for required fields and valid formats.

- **💼 Exception Handling:**
  - Graceful handling of exceptions with proper error messages and HTTP status codes.

- **📦 Service Layer:**
  - Service layer to encapsulate business logic.
  - Separation of concerns between controller, service, and repository.

- **🧪 Testing:**
  - Unit tests for service methods using JUnit and Mockito.
  - Integration tests for controllers.

- **🔄 Dependency Injection:**
  - Utilization of Spring's dependency injection for managing components.

- **🔧 Build and Run:**
  - Build using Maven.
  - Run the service locally.

## **Watch the Demo Video 🎥**
https://github.com/Ayush20021989/Staples_Intern_Task1/assets/100331783/e7c2f6fd-575e-49a1-a783-5d82ec0f918d

## **Contributing**
Feel free to contribute, suggest improvements, or report issues! 🚀

## **𝙷𝚊𝚙𝚙𝚢 𝙲𝚘𝚍𝚒𝚗𝚐! 🌟**
