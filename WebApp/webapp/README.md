# Web Application

## Overview
This web application allows users to view travel schedules and make reservations. Users can enter their personal information and select a payment method.

## Project Structure
- `src/main/webapp/WEB-INF/views/voyageurshoraires.jsp`: Displays the schedule for travelers with a reservation link.
- `src/main/webapp/WEB-INF/views/mes_coordonnees.jsp`: Contains a form for user input (full name, email, age, phone number, payment method).
- `src/main/webapp/resources/css/styles.css`: Styles for the web application.
- `src/main/webapp/resources/js/script.js`: Client-side validation and interactive features.
- `src/main/webapp/index.jsp`: Main entry point of the application.
- `src/main/java/com/example/webapp/controller/ReservationController.java`: Handles reservation logic and input validation.
- `src/main/java/com/example/webapp/model/Reservation.java`: Represents the reservation model.

## Setup Instructions
1. Ensure you have Maven installed.
2. Clone the repository.
3. Navigate to the project directory and run `mvn clean install`.
4. Deploy the application on a servlet container (e.g., Apache Tomcat).
5. Access the application via your web browser.