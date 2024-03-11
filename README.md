# Task Manager Application Using Spring Boot
This is my first **CRUD** (Create, Read, Update, Delete) application using spring boot, it's a user-friendly Task Management System. Built using java as a backend and bootstrap as a front-end. It features an authorities based user registration system.
the following technologies have been used to facilitate the development proccess Spring Boot Web, Spring Data JPA & Hibernate, Spring Scurity, MySQL Database, Thymeleaf, HTML5 & Bootstrap Spring Data JPA Test.

## 📝Table of Contents
- [Description](#Description)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Database](#Databsse)
- [Demo](#Demo)

## 📄Description
Description for Spring Boot Task Manager Application:

This Spring Boot Task Manager Application provides a robust platform for managing tasks efficiently. Leveraging the MySQL database structure, the application seamlessly integrates user authentication, role management, and task tracking functionalities.

Key Features:

1. **User Management**: Users can register, login, and manage their accounts. The system ensures security through password hashing and account enabling/disabling functionality.

2. **Role-Based Access Control**: With a flexible role-based access control system, administrators can assign roles to users, controlling their permissions within the application. Roles such as "Admin" and "User" are predefined, but the system is extensible for custom roles as per business requirements.

3. **Task Tracking**: Users can create, update, prioritize, and mark tasks as complete. Each task includes details such as name, priority, due date, and status, providing a comprehensive overview of ongoing activities.

4. **Efficient Database Schema**: The MySQL database schema is designed for optimal performance and scalability. It includes tables for users, roles, tasks, and user-role mappings, facilitating seamless data management.

5. **Data Integrity**: Foreign key constraints ensure data integrity, maintaining referential integrity between tables and preventing orphaned records.

6. **API Integration**: The application provides RESTful APIs for seamless integration with other systems or frontend frameworks. These APIs enable developers to extend the functionality of the application or integrate it into existing workflows.

7. **Customization and Extensibility**: Built on Spring Boot, the application is highly customizable and extensible. Developers can easily add new features, customize existing functionalities, or integrate additional modules as per business requirements.

## 🚀Features

- User registration and authentication.
- Create, Read, Update, and Delete Task.
- Input form validation.
- An admin dashboard where admin can have full access over the application.
- RESTful API design.
  
## 📖prerequisites
Before you begin, ensure you have the following setup:

- Java Development Kit (JDK) 17+ installed.
- Maven installed.
- Database setup in [Database](#Databsse) section.

## 🛢️Database
- use [this script to setup the database schema on your system](https://github.com/eslamsamy226/taskManager/blob/main/databse.sql)
- you [application.properties](https://github.com/eslamsamy226/taskManager/blob/main/src/main/resources/application.properties) file to add your database connection.
- Here is an ER digram of the database:
- ![https://github.com/eslamsamy226/taskManager/blob/main/er.PNG](https://github.com/eslamsamy226/taskManager/blob/main/er.PNG) 

## 📽️Demo

https://github.com/eslamsamy226/taskManager/assets/128985943/457a1f36-6fb9-475d-ab50-0d5ccaaa85c9



  
