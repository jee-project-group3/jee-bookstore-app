# jee-bookstore-app# Bookstore JEE Application

## Project Overview

This project is a web-based Bookstore Management System developed as a 3-tier Java EE (JEE) web application. The system enables users to register, authenticate, and perform operations such as browsing books, viewing details, and interacting with a catalog in a secure and efficient manner. The application demonstrates the separation of concerns through presentation, business logic, and persistence layers and leverages JEE technologies such as Servlets, JSPs, Enterprise JavaBeans (EJB), and JPA for robust enterprise-level functionality.

## Architecture

The application follows a layered architecture:

- **Presentation Layer:** Implements JSPs and Servlets for user interaction and interface rendering.
- **Business Logic Layer:** Contains stateless EJBs to encapsulate business rules and coordinate application logic.
- **Persistence Layer:** Utilizes Java Persistence API (JPA) to interact with a relational database for storing and retrieving book-related data.

## Features

- User registration and login functionality
- Secure session-based authentication
- Book browsing and detailed view
- Role-based access (e.g., admin functionality can be extended)
- Modular structure to support scalability and maintenance

## Technologies Used

- Java EE (Servlets, JSP, EJB, JPA)
- Apache Tomcat / GlassFish (recommended application server)
- MySQL / H2 Database
- Bootstrap 5 for responsive front-end design
- Git and GitHub for version control and collaboration

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/your-org/bookstore-jee-app.git
