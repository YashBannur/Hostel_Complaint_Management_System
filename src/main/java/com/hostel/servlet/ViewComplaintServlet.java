package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewComplaintServlet")
public class ViewComplaintServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int complaintId =
                Integer.parseInt(
                        request.getParameter("id"));

        ComplaintDAO dao =
                new ComplaintDAO();

        Complaint complaint =
                dao.getComplaintById(
                        complaintId);

        request.setAttribute(
                "complaint",
                complaint);

        request.getRequestDispatcher(
                "complaint-details.jsp")
                .forward(
                        request,
                        response);
    }
}