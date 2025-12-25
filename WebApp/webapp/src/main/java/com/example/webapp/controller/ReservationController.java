package com.example.webapp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/reserve")
public class ReservationController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String phoneNumber = request.getParameter("phoneNumber");
        String paymentMethod = request.getParameter("paymentMethod");

        // Here you can add logic to process the reservation
        // For example, validate inputs and save to the database

        request.setAttribute("fullName", fullName);
        request.setAttribute("email", email);
        request.setAttribute("age", age);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("paymentMethod", paymentMethod);

        // Redirect to a confirmation page or back to the form
        request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp").forward(request, response);
    }
}