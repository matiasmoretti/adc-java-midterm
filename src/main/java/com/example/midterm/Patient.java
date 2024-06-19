package com.example.midterm;

public class Patient {

    int id ;
    String symptoms, diagnosis, medicines;
    boolean ward;

    public void setId(int id) {
        this.id = id;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public void setWard(Boolean ward) {
        this.ward = ward;
    }

    public int getId() {
        return id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public Patient(int id, String symptoms, String diagnosis, String medicines, Boolean ward) {
        this.id = id;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
        this.ward = ward;
    }

}

