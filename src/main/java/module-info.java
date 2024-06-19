module com.example.midterm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    requires java.desktop;


    opens com.example.midterm to javafx.fxml;
    exports com.example.midterm;
}