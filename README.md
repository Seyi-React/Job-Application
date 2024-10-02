# Job Application Management System


## Project Description
The **Job Application Management System** is a Spring Boot application that allows users to manage job applications.
It provides features for posting new jobs, editing existing job postings, deleting job posts, and retrieving all available job posts.
This application is designed to help recruiters streamline the process of managing job vacancies.

Key Features:
- Post new job listings
- Edit existing job postings
- Delete job postings
- View all job postings


## Technologies Used
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (or other database)
- REST API
- Maven
- Lombok
- Postman (for testing API endpoints)

## Prerequisites
- Java 17 or later
- Maven 3.6+
- MySQL (or any relational database)
- Postman (optional for API testing)

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/seyi-react/jobpplication.git
   cd Jobapplication
   ```

2. **Configure the database**
    - Open `src/main/resources/application.properties`.
    - Configure the following properties for MySQL or another database:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/jobdb
      spring.datasource.username=root
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```

3. **Build and run the application**
    - Use Maven to build the application:
      ```bash
      mvn clean install
      ```
    - Run the Spring Boot application:
      ```bash
      mvn spring-boot:run
      ```

4. **Access the application**
    - The application will be running at:
      ```
      http://localhost:8080
      ```


