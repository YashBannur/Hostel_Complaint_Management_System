package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hostel.util.DBConnection;

public class WardenDAO {

    public ResultSet loginWarden(
            String email,
            String password) {

        ResultSet rs = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM wardens WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return rs;
    }
}