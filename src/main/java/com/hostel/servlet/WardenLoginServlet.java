package com.hostel.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import com.hostel.dao.WardenDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/WardenLoginServlet")
public class WardenLoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =request.getParameter("email");

        String password = request.getParameter("password");

        WardenDAO dao = new WardenDAO();

        try {

            ResultSet rs =dao.loginWarden(email, password);

            if(rs.next()) {

                HttpSession session = request.getSession();

                session.setAttribute("wardenId",rs.getInt("warden_id"));

                session.setAttribute("wardenName",rs.getString("full_name"));

                response.sendRedirect("WardenDashboardServlet");

            } else {

                response.getWriter().println("<h2>Invalid Credentials</h2>");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}