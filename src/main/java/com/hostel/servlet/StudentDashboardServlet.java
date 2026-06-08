package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudentDashboardServlet")
public class StudentDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null) {

            response.sendRedirect(
                    "student-login.html");

            return;
        }

        int studentId =
                (Integer) session.getAttribute(
                        "studentId");

        ComplaintDAO dao =
                new ComplaintDAO();

        int total =
                dao.getTotalComplaints(
                        studentId);

        int pending =
                dao.getPendingComplaints(
                        studentId);

        int completed =
                dao.getCompletedComplaints(
                        studentId);

        int inProgress =
                total - pending - completed;

        request.setAttribute(
                "total",
                total);

        request.setAttribute(
                "pending",
                pending);

        request.setAttribute(
                "completed",
                completed);

        request.setAttribute(
                "inProgress",
                inProgress);

        request.getRequestDispatcher(
                "student-dashboard.jsp")
                .forward(request, response);
    }
}