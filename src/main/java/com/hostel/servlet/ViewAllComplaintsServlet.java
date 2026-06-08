package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewAllComplaintsServlet")
public class ViewAllComplaintsServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao =
                new ComplaintDAO();

        List<Complaint> complaints =
                dao.getAllComplaints();

        request.setAttribute(
                "complaints",
                complaints);

        request.getRequestDispatcher(
                "all-complaints.jsp")
                .forward(request, response);
    }
}