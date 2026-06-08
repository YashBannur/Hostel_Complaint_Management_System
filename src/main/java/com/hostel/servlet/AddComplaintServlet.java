package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddComplaintServlet")
public class AddComplaintServlet extends HttpServlet {

    @Override
    protected void doPost(
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

        String category =
                request.getParameter(
                        "category");

        String priority =
                request.getParameter(
                        "priority");

        String description =
                request.getParameter(
                        "description");

        Complaint complaint =
                new Complaint();

        complaint.setStudentId(
                studentId);

        complaint.setCategory(
                category);

        complaint.setPriority(
                priority);

        complaint.setDescription(
                description);

        ComplaintDAO dao =
                new ComplaintDAO();

        boolean status =
                dao.addComplaint(
                        complaint);

        if(status) {

        	response.sendRedirect("StudentDashboardServlet");

        } else {

            response.getWriter().println(
                    "<h2>Complaint Submission Failed!</h2>");
        }
    }
}