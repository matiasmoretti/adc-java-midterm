package com.example.midterm;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


//import com.sun.jdi.connect.spi.Connection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;


public class MainController implements Initializable {


    @FXML
    private TableView<Patient> table_patients;

    @FXML
    private TableColumn<Patient, Integer> col_id;

    @FXML
    private TableColumn<Patient, String> col_symptoms;

    @FXML
    private TableColumn<Patient, String> col_diagnosis;

    @FXML
    private TableColumn<Patient, String> col_medicines;

    @FXML
    private TableColumn<Patient, String> col_ward;

    @FXML
    private TextField txt_symptoms;

    @FXML
    private TextField txt_diagnosis;

    @FXML
    private TextField txt_medicines;

    @FXML
    private TextField txt_id;

    @FXML
    private CheckBox chk_ward;

    ObservableList<Patient> listM;
    ObservableList<Patient> dataList;



    int index = -1;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    public void Add_patient (){
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into patients (symptoms, diagnosis, medicines, ward)values(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_symptoms.getText());
            pst.setString(2, txt_diagnosis.getText());
            pst.setString(3, txt_medicines.getText());
            pst.setString(4, chk_ward.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Patient Added");
            //UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
        index = table_patients.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        txt_symptoms.setText(col_symptoms.getCellData(index).toString());
        txt_diagnosis.setText(col_diagnosis.getCellData(index));
        txt_medicines.setText(col_medicines.getCellData(index));
        chk_ward.setText(String.valueOf(col_ward.getCellData(index)));

    }

    public void UpdateTable(){
        col_symptoms.setCellValueFactory(new PropertyValueFactory<Patient,String>("symptoms"));
        col_diagnosis.setCellValueFactory(new PropertyValueFactory<Patient,String>("diagnosis"));
        col_medicines.setCellValueFactory(new PropertyValueFactory<Patient,String>("medicines"));
        col_ward.setCellValueFactory(new PropertyValueFactory<Patient,String>("ward"));

        listM = mysqlconnect.getPatients(txt_id.getText());
        table_patients.setItems(listM);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //UpdateTable();
        // Code Source in description
    }
}