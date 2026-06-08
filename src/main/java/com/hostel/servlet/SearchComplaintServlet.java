package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SearchComplaintServlet")
public class SearchComplaintServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String category =request.getParameter("category");

        ComplaintDAO dao =new ComplaintDAO();

        List<Complaint> complaints =dao.getComplaintsByCategory(category);

        int total =dao.getTotalComplaints();

        int pending =dao.getPendingComplaints();

        int completed =dao.getCompletedComplaints();

        int inProgress =dao.getInProgressComplaints();

        request.setAttribute("total",total);

        request.setAttribute("pending",pending);

        request.setAttribute("completed",completed);

        request.setAttribute("inProgress",inProgress);

        request.setAttribute("recentComplaints",complaints);

        request.getRequestDispatcher("warden-dashboard.jsp")
                .forward(request, response);
    }
}