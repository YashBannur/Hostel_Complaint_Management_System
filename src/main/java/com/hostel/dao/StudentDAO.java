package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hostel.util.DBConnection;

public class StudentDAO {

    // Student Registration
    public boolean registerStudent(
            String fullName,
            String email,
            String password,
            String roomNumber) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO students(full_name,email,password,room_number) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, roomNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Login Validation
    public boolean validateStudent(
            String email,
            String password) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM students WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get Student Details For Session
    public ResultSet getStudentByLogin(
            String email,
            String password) {

        ResultSet rs = null;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM students WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}