package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SubmitFeedbackServlet")
public class SubmitFeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int complaintId =
                Integer.parseInt(
                        request.getParameter(
                                "complaintId"));

        int rating =
                Integer.parseInt(
                        request.getParameter(
                                "rating"));

        String feedback =
                request.getParameter(
                        "feedback");

        ComplaintDAO dao =
                new ComplaintDAO();

        boolean status =
                dao.submitFeedback(
                        complaintId,
                        rating,
                        feedback);

        if(status) {

            response.sendRedirect(
                    "ViewComplaintsServlet");

        } else {

            response.getWriter().println(
                    "<h2>Feedback Failed!</h2>");
        }
    }
}