package com.hostel.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import com.hostel.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        StudentDAO dao = new StudentDAO();

        try {

            ResultSet rs =
                    dao.getStudentByLogin(
                            email,
                            password);

            if(rs.next()) {

                HttpSession session = request.getSession();

                session.setAttribute("studentId",  rs.getInt("student_id"));

                session.setAttribute("studentName",rs.getString("full_name"));

                session.setAttribute("email",      rs.getString("email"));

                session.setAttribute("roomNumber", rs.getString("room_number"));

                response.sendRedirect("StudentDashboardServlet");

            } else {

                response.getWriter().println("<h2>Invalid Email or Password!</h2>");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}