package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.ComplaintDAO;
import com.hostel.model.Complaint;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ExportComplaintPdfServlet")
public class ExportComplaintPdfServlet
        extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int complaintId =
                    Integer.parseInt(
                            request.getParameter("id"));

            ComplaintDAO dao =
                    new ComplaintDAO();

            Complaint complaint =
                    dao.getComplaintById(
                            complaintId);

            response.setContentType(
                    "application/pdf");

            response.setHeader(
                    "Content-Disposition",
                    "attachment; filename=Complaint_"
                    + complaintId + ".pdf");

            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,
                    response.getOutputStream());

            document.open();

            Font titleFont =
                    new Font(
                            FontFamily.HELVETICA,
                            18,
                            Font.BOLD);

            document.add(
                    new Paragraph(
                            "Hostel Complaint Report",
                            titleFont));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Complaint ID : "
                            + complaint.getComplaintId()));

            document.add(
                    new Paragraph(
                            "Student ID : "
                            + complaint.getStudentId()));

            document.add(
                    new Paragraph(
                            "Category : "
                            + complaint.getCategory()));

            document.add(
                    new Paragraph(
                            "Priority : "
                            + complaint.getPriority()));

            document.add(
                    new Paragraph(
                            "Status : "
                            + complaint.getStatus()));

            document.add(
                    new Paragraph(
                            "Worker : "
                            + complaint.getWorkerName()));

            document.add(
                    new Paragraph(
                            "Date : "
                            + complaint.getCreatedAt()));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Description"));

            document.add(
                    new Paragraph(
                            complaint.getDescription()));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Rating : "
                            + complaint.getRating()
                            + "/5"));

            document.add(
                    new Paragraph(
                            "Feedback : "
                            + complaint.getFeedback()));

            document.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}