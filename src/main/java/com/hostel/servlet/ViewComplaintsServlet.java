package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewComplaintsServlet")
public class ViewComplaintsServlet extends HttpServlet {

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

        List<Complaint> complaints =
                dao.getComplaintsByStudentId(
                        studentId);

        request.setAttribute(
                "complaints",
                complaints);

        request.getRequestDispatcher(
                "my-complaints.jsp")
                .forward(request, response);
    }
}