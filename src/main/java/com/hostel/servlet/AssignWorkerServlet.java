package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AssignWorkerServlet")
public class AssignWorkerServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int complaintId =
                Integer.parseInt(
                        request.getParameter(
                                "complaintId"));

        String workerName =
                request.getParameter(
                        "workerName");

        String status =
                request.getParameter(
                        "status");

        ComplaintDAO dao =
                new ComplaintDAO();

        boolean result =
                dao.assignWorker(
                        complaintId,
                        workerName,
                        status);

        if(result) {

            response.sendRedirect(
                    "ViewAllComplaintsServlet");

        } else {

            response.getWriter().println(
                    "<h2>Update Failed</h2>");
        }
    }
}