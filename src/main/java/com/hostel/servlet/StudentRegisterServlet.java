package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fullName =
                request.getParameter("full_name");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        String roomNumber =
                request.getParameter("room_number");

        StudentDAO dao = new StudentDAO();

        boolean status =
                dao.registerStudent(
                        fullName,
                        email,
                        password,
                        roomNumber);

        if(status) {

            response.sendRedirect(
                    "student-login.html");
        }
        else {

            response.getWriter().println(
                    "<h2>Registration Failed!</h2>");
        }
    }
}