package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/WardenDashboardServlet")
public class WardenDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao =
                new ComplaintDAO();

        int total =
                dao.getTotalComplaints();

        int pending =
                dao.getPendingComplaints();

        int completed =
                dao.getCompletedComplaints();

        int inProgress =
                dao.getInProgressComplaints();

        List<Complaint> recentComplaints =
                dao.getRecentComplaints();

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

        request.setAttribute(
                "recentComplaints",
                recentComplaints);

        request.getRequestDispatcher(
                "warden-dashboard.jsp")
                .forward(request, response);
    }
}