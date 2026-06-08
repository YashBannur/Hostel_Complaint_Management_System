package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hostel.model.Complaint;
import com.hostel.util.DBConnection;

public class ComplaintDAO {

    // Add Complaint
    public boolean addComplaint(Complaint complaint) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO complaints(student_id, category, priority, description) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, complaint.getStudentId());
            ps.setString(2, complaint.getCategory());
            ps.setString(3, complaint.getPriority());
            ps.setString(4, complaint.getDescription());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // View Complaints By Student ID
    public List<Complaint> getComplaintsByStudentId(int studentId) {

        List<Complaint> complaints = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM complaints WHERE student_id=? ORDER BY complaint_id DESC";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Complaint complaint =
                        new Complaint();

                complaint.setComplaintId(
                        rs.getInt("complaint_id"));

                complaint.setStudentId(
                        rs.getInt("student_id"));

                complaint.setCategory(
                        rs.getString("category"));

                complaint.setPriority(
                        rs.getString("priority"));

                complaint.setDescription(
                        rs.getString("description"));

                complaint.setStatus(
                        rs.getString("status"));

                complaint.setWorkerName(
                        rs.getString("worker_name"));
                complaint.setCreatedAt(
                	    rs.getString("complaint_date"));
                
                complaint.setRating(
                        rs.getInt("rating"));

                complaint.setFeedback(
                        rs.getString("feedback"));

                complaints.add(complaint);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return complaints;
    }
    
    public int getTotalComplaints(int studentId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE student_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }
            
            

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
    public int getPendingComplaints(int studentId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE student_id=? AND status='Pending'";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
    public int getCompletedComplaints(int studentId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE student_id=? AND status='Completed'";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
    
    public List<Complaint> getAllComplaints() {

        List<Complaint> complaints =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM complaints ORDER BY complaint_id DESC";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Complaint complaint =
                        new Complaint();

                complaint.setComplaintId(
                        rs.getInt("complaint_id"));

                complaint.setStudentId(
                        rs.getInt("student_id"));

                complaint.setCategory(
                        rs.getString("category"));

                complaint.setPriority(
                        rs.getString("priority"));

                complaint.setDescription(
                        rs.getString("description"));

                complaint.setStatus(
                        rs.getString("status"));

                complaint.setWorkerName(
                        rs.getString("worker_name"));
                complaint.setCreatedAt(
                	    rs.getString("complaint_date"));
                
                complaint.setRating(
                        rs.getInt("rating"));

                complaint.setFeedback(
                        rs.getString("feedback"));

                complaints.add(complaint);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return complaints;
    }
    
    
    public int getTotalComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    
    public int getPendingComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE status='Pending'";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    
    public int getCompletedComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE status='Completed'";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    
    public int getInProgressComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT COUNT(*) FROM complaints WHERE status='In Progress'";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    
    
    public boolean assignWorker(
            int complaintId,
            String workerName,
            String status) {

        boolean result = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE complaints SET worker_name=?, status=? WHERE complaint_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, workerName);

            ps.setString(2, status);

            ps.setInt(3, complaintId);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                result = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return result;
    }
    
    public boolean updateComplaintStatus(
            int complaintId,
            String status) {

        boolean result = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE complaints SET status=? WHERE complaint_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, status);

            ps.setInt(2, complaintId);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                result = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return result;
    }
    
    public boolean submitFeedback(
            int complaintId,
            int rating,
            String feedback) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE complaints SET rating=?, feedback=? WHERE complaint_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, rating);

            ps.setString(2, feedback);

            ps.setInt(3, complaintId);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    
    
    public List<Complaint> getRecentComplaints() {

        List<Complaint> complaints =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM complaints ORDER BY complaint_id DESC LIMIT 5";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Complaint complaint =
                        new Complaint();

                complaint.setComplaintId(
                        rs.getInt("complaint_id"));

                complaint.setCategory(
                        rs.getString("category"));

                complaint.setStatus(
                        rs.getString("status"));

                complaints.add(complaint);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return complaints;
    }
    
    
    public List<Complaint> getComplaintsByCategory(
            String category) {

        List<Complaint> complaints =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query;

            PreparedStatement ps;

            if("All".equals(category)) {

                query =
                        "SELECT * FROM complaints ORDER BY complaint_id DESC";

                ps =
                        con.prepareStatement(query);

            } else {

                query =
                        "SELECT * FROM complaints WHERE category=? ORDER BY complaint_id DESC";

                ps =
                        con.prepareStatement(query);

                ps.setString(1, category);
            }

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Complaint complaint =
                        new Complaint();

                complaint.setComplaintId(
                        rs.getInt("complaint_id"));

                complaint.setStudentId(
                        rs.getInt("student_id"));

                complaint.setCategory(
                        rs.getString("category"));

                complaint.setPriority(
                        rs.getString("priority"));

                complaint.setStatus(
                        rs.getString("status"));

                complaint.setWorkerName(
                        rs.getString("worker_name"));

                complaint.setCreatedAt(
                        rs.getString("complaint_date"));

                complaint.setRating(
                        rs.getInt("rating"));

                complaint.setFeedback(
                        rs.getString("feedback"));

                complaints.add(
                        complaint);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return complaints;
    }
    
    
    public Complaint getComplaintById(
            int complaintId) {

        Complaint complaint = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM complaints WHERE complaint_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, complaintId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                complaint =
                        new Complaint();

                complaint.setComplaintId(
                        rs.getInt("complaint_id"));

                complaint.setStudentId(
                        rs.getInt("student_id"));

                complaint.setCategory(
                        rs.getString("category"));

                complaint.setPriority(
                        rs.getString("priority"));

                complaint.setDescription(
                        rs.getString("description"));

                complaint.setStatus(
                        rs.getString("status"));

                complaint.setWorkerName(
                        rs.getString("worker_name"));

                complaint.setCreatedAt(
                        rs.getString("complaint_date"));

                complaint.setRating(
                        rs.getInt("rating"));

                complaint.setFeedback(
                        rs.getString("feedback"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return complaint;
    }
    
}