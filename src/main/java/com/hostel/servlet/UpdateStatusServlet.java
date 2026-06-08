package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int complaintId =
                Integer.parseInt(
                        request.getParameter(
                                "complaintId"));

        String status =
                request.getParameter(
                        "status");

        ComplaintDAO dao =
                new ComplaintDAO();

        boolean result =
                dao.updateComplaintStatus(
                        complaintId,
                        status);

        if(result) {

            response.sendRedirect(
                    "ViewAllComplaintsServlet");

        } else {

            response.getWriter().println(
                    "<h2>Status Update Failed</h2>");
        }
    }
}