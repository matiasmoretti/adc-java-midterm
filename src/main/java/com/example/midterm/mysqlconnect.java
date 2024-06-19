package com.example.midterm;

import com.example.midterm.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mysqlconnect {

    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sample","root",".cana2002,");
            // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public static ObservableList<Patient> getPatients(String idPatient){
        Connection conn = ConnectDb();
        ObservableList<Patient> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from patients where id = ?");
            ps.setString(1, idPatient);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Patient(Integer.parseInt(rs.getString("id")), rs.getString("symptoms"), rs.getString("diagnosis"), rs.getString("medicines"), rs.getBoolean("ward")));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
