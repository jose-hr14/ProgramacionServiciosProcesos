module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}