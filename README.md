# 🚅 AL BORAQ - Train Reservation Application

**Al Boraq** is a web-based application built using the Jakarta EE architecture, designed for train ticket management and reservation. This academic project was developed to apply software development concepts and the MVC architectural pattern in a real-world scenario.

The application provides a complete solution, from route searching to PDF ticket generation, including a secure payment simulation system.

---

## 📋 Table of Contents
- [Features](#-features)
- [Technical Architecture](#-technical-architecture)
- [System Design (UML)](#-system-design-uml)
- [Installation and Deployment](#-installation-and-deployment)

---

## 🚀 Features

The application covers the essential functionalities of a modern railway ticketing system:

### **Passenger Area**
- User account creation and authentication.
- User profile management.

### **Advanced Search**
- Selection of departure and arrival stations.
- Travel date selection.
- Choice between one-way or round-trip journeys.

### **Ticket Reservation**
- Schedule selection and fare consultation.
- Choice of travel class (First or Second Class).
- Passenger quantity management.
- Real-time seat availability management.

### **Secure Payment**
- Simulated credit card payment interface.
- Validation and verification of banking information.

### **PDF Ticketing**
- Automatic generation and display of transport tickets in PDF format after confirmation.

### **Administration Panel**
- Management of reference data such as trains, stations, and schedules through the back-office system.

---

## 🛠 Technical Architecture

The project follows a strict **MVC (Model-View-Controller)** architecture, ensuring a clear separation between business logic, data access, and the user interface.

### Technology Stack
- **Programming Language:** Java
- **Web Framework:** Jakarta EE (Servlets, JSP)
- **Application Server:** Apache Tomcat
- **Database:** MySQL
- **Data Access:** JDBC (DAO Pattern)
- **Project Management:** Maven
- **Frontend:** HTML5, CSS3, JSP

### Project Structure
- **WEB Layer:** Controllers (Servlets) and Views (JSP) handling user interactions.
- **BUSINESS Layer:** Classes representing the application logic (`Train`, `Reservation`, `AlBoraq`, etc.).
- **DAO Layer:** Handles persistence and SQL database interactions.

---

## 📊 System Design (UML)

The system modeling is based on standard UML diagrams:

- **Use Case Diagram:** Represents interactions between actors and the system.
- **Class Diagram:** Defines the structure of core entities such as `Passenger`, `Ticket`, `Trip`, `BankCard`, and others.

---

## ⚙️ Installation and Deployment

To run the project locally:

### 1. Prerequisites
- JDK (Java Development Kit) 11+
- Apache Tomcat (v9 or v10)
- MySQL Server
- Maven

### 2. Configuration
- Clone the GitHub repository.
- Create a local MySQL database named `Gestion_Reservation`.
- Configure the JDBC connection in the file `src/Dao/dbconnexion.java` using your local database credentials.

### 3. Launch

Compile the project:

```bash
mvn clean install
```

Deploy the generated `.war` file to your Tomcat server.

Access the application at:

```bash
http://localhost:8080/Al-Boraq/acceuil
```

---

© 2025 Al Boraq Project — All Rights Reserved.
